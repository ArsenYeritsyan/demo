package com.example.demo.persistance.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity()
@Table(appliesTo = "movies")
public class Movie implements Serializable {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20)
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Producer.class)
    private Set<Producer> producers;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Comment.class)
    private List<Comment> comments;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    private User user;

    private Long duration;
    @NotNull
    @Lob
    private String body;
    @Lob
    private byte[] pic;

    @Enumerated(EnumType.STRING)
    private MovieGenre movieGenre;

    public Movie(String title, User user, Long duration, String body, Producer producer, MovieGenre movieGenre) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.duration = duration;
        this.addProducer(producer);
        this.movieGenre = movieGenre;
    }

    public Movie() {
    }

    public void addProducer(Producer producer) {
        producers.add(producer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) &&
                Objects.equals(title, movie.title) &&
                Objects.equals(producers, movie.producers) &&
                Objects.equals(comments, movie.comments) &&
                Objects.equals(user, movie.user) &&
                Objects.equals(duration, movie.duration) &&
                Objects.equals(body, movie.body) &&
                Arrays.equals(pic, movie.pic) &&
                movieGenre == movie.movieGenre;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, producers, comments, user, duration, body, movieGenre);
        result = 31 * result + Arrays.hashCode(pic);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", producers=" + producers +
                ", comments=" + comments +
                ", user=" + user +
                ", duration=" + duration +
                ", body='" + body + '\'' +
                ", pic=" + Arrays.toString(pic) +
                ", movieGenre=" + movieGenre +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Producer> getProducers() {
        return producers;
    }

    public void setProducers(Set<Producer> producers) {
        this.producers = producers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public MovieGenre getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(MovieGenre movieGenre) {
        this.movieGenre = movieGenre;
    }

}
