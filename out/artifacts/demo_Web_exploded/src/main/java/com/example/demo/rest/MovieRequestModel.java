package com.example.demo.rest;

import com.example.demo.persistance.model.MovieGenre;
import com.example.demo.persistance.model.Producer;
import com.example.demo.persistance.model.User;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class MovieRequestModel implements Serializable {
    private static final long serialVersionUID = 9086611151436149608L;
    private String title;
    private String body;
    private Long author_id;
    private Producer producer;

}
