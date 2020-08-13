package com.example.demo.rest.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

public class CommentResponseModel implements Serializable {
    private Long id;
    private String body;
    private UserResponseModel userResponseModel;
    private MovieResponseModel movieResponseModel;

    public CommentResponseModel(Long id, String body, UserResponseModel userResponseModel, MovieResponseModel movieResponseModel) {
        this.id = id;
        this.body = body;
        this.userResponseModel = userResponseModel;
        this.movieResponseModel = movieResponseModel;
    }

    public CommentResponseModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentResponseModel that = (CommentResponseModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(body, that.body) &&
                Objects.equals(userResponseModel, that.userResponseModel) &&
                Objects.equals(movieResponseModel, that.movieResponseModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body, userResponseModel, movieResponseModel);
    }

    @Override
    public String toString() {
        return "CommentResponseModel{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", userResponseModel=" + userResponseModel +
                ", movieResponseModel=" + movieResponseModel +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserResponseModel getUserResponseModel() {
        return userResponseModel;
    }

    public void setUserResponseModel(UserResponseModel userResponseModel) {
        this.userResponseModel = userResponseModel;
    }

    public MovieResponseModel getMovieResponseModel() {
        return movieResponseModel;
    }

    public void setMovieResponseModel(MovieResponseModel movieResponseModel) {
        this.movieResponseModel = movieResponseModel;
    }
}
