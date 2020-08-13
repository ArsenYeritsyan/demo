package com.example.demo.rest;

import com.example.demo.persistance.model.MovieGenre;
import org.springframework.core.serializer.Serializer;

import java.io.Serializable;
import java.util.Set;

public class MovieResponseModel implements Serializable {
    private static final long serialVersionUID = -2666461033695610026L;
private Long id;
    private String title;
    private Long duration;
    private String body;
    private byte[] pic;
    private MovieGenre movieGenre;
    private Set<Process> produsers;


}
