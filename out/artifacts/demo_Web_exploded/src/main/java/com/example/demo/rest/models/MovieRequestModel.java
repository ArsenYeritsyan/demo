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
}
