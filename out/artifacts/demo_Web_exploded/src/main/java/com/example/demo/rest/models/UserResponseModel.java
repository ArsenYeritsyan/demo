package com.example.demo.rest.models;

import com.example.demo.persistance.model.Comment;
import com.example.demo.persistance.model.Movie;
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
public class UserResponseModel  implements Serializable {
    private Long id;
    private String email;
    private String name;
    private String username;
    private String password;
    private List<Comment> comments;
    private Set<Movie> movies;

    public UserResponseModel(Long id, String email, String name, String username, String password, List<Comment> comments, Set<Movie> movies) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
        this.comments = comments;
        this.movies = movies;
    }

    public UserResponseModel() {

    }
}
