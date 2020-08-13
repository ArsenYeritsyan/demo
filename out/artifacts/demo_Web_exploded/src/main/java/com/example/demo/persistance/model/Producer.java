package com.example.demo.persistance.model;

import com.example.demo.rest.models.ProducerResponseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity(name = "producer")
@Table()
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @ManyToMany(mappedBy = "producers")
    private Set<Movie> movies;

    public Producer(String name, int age) {
        this.name=name;
        this.age=age;
    }
    public Producer() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return age == producer.age &&
                Objects.equals(id, producer.id) &&
                Objects.equals(name, producer.name) &&
                Objects.equals(movies, producer.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, movies);
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", movies=" + movies +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
