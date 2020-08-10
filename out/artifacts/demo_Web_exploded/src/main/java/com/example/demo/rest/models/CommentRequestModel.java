package com.example.demo.rest.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

public class CommentRequestModel implements Serializable {
    private Long user_id;
    private String body;
    private Long movie_id;

    public CommentRequestModel(Long user_id, String body, Long movie_id) {
        this.user_id = user_id;
        this.body = body;
        this.movie_id = movie_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentRequestModel that = (CommentRequestModel) o;
        return Objects.equals(user_id, that.user_id) &&
                Objects.equals(body, that.body) &&
                Objects.equals(movie_id, that.movie_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, body, movie_id);
    }

    @Override
    public String toString() {
        return "CommentRequestModel{" +
                "user_id=" + user_id +
                ", body='" + body + '\'' +
                ", movie_id=" + movie_id +
                '}';
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }
}
