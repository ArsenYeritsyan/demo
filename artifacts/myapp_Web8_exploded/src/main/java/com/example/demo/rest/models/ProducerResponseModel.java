package com.example.demo.rest.models;

import com.example.demo.persistance.model.Movie;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProducerResponseModel implements Serializable {
    private Long id;
    private String name;
    private int age;
    private Set<MovieResponseModel> movies;

    public ProducerResponseModel(Long id, String name, int age, Set<MovieResponseModel> movies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.movies = movies;
    }

    public ProducerResponseModel() {
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

    public Set<MovieResponseModel> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieResponseModel> movies) {
        this.movies = movies;
    }
}
