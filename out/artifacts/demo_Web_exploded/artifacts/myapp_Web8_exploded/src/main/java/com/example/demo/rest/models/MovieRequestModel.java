package com.example.demo.rest.models;

import com.example.demo.persistance.model.MovieGenre;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MovieRequestModel implements Serializable {
    private String title;
    private String body;
    private Long duration;
    private Long user_id;
    private Long producer_id;
    private MovieGenre MovieGenre;

    public MovieRequestModel(String title, String body, Long duration, Long user_id, Long producer_id, com.example.demo.persistance.model.MovieGenre movieGenre) {
        this.title = title;
        this.body = body;
        this.duration = duration;
        this.user_id = user_id;
        this.producer_id = producer_id;
        MovieGenre = movieGenre;
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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getProducer_id() {
        return producer_id;
    }

    public void setProducer_id(Long producer_id) {
        this.producer_id = producer_id;
    }

    public com.example.demo.persistance.model.MovieGenre getMovieGenre() {
        return MovieGenre;
    }

    public void setMovieGenre(com.example.demo.persistance.model.MovieGenre movieGenre) {
        MovieGenre = movieGenre;
    }
}
