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
}
