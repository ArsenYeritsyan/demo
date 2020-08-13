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
}
