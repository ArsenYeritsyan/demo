package com.example.demo.rest.models;

import com.example.demo.persistance.model.Comment;
import com.example.demo.persistance.model.MovieGenre;
import com.example.demo.persistance.model.Producer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MovieResponseModel implements Serializable {
    private Long id;
    private String title;
    private String body;
    private Long duration;
    private UserResponseModel user;
    private Set<ProducerResponseModel> producers;
    private MovieGenre MovieGenre;
    private List<CommentResponseModel> comments;

    public MovieResponseModel(Long id, String title, String body, Long duration, UserResponseModel user, Set<ProducerResponseModel> producers, com.example.demo.persistance.model.MovieGenre movieGenre, List<CommentResponseModel> comments) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.duration = duration;
        this.user = user;
        this.producers = producers;
        MovieGenre = movieGenre;
        this.comments = comments;
    }

    public MovieResponseModel() {
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public UserResponseModel getUser() {
        return user;
    }

    public void setUser(UserResponseModel user) {
        this.user = user;
    }

    public Set<ProducerResponseModel> getProducers() {
        return producers;
    }

    public void setProducers(Set<ProducerResponseModel> producers) {
        this.producers = producers;
    }

    public com.example.demo.persistance.model.MovieGenre getMovieGenre() {
        return MovieGenre;
    }

    public void setMovieGenre(com.example.demo.persistance.model.MovieGenre movieGenre) {
        MovieGenre = movieGenre;
    }

    public List<CommentResponseModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentResponseModel> comments) {
        this.comments = comments;
    }
}
