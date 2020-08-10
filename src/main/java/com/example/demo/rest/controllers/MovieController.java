package com.example.demo.rest.controllers;

import com.example.demo.rest.models.MovieRequestModel;
import com.example.demo.rest.models.MovieResponseModel;
import com.example.demo.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;

    }

    @PostMapping(value = "/movie")
    public ResponseEntity<MovieResponseModel> createMovie(@RequestBody MovieRequestModel movieRequestModel) {
        MovieResponseModel movie = movieService.createMovie(movieRequestModel);
        return ResponseEntity.ok(movie);
    }

    @PutMapping(value = "/movie/{id}")
    public ResponseEntity<MovieResponseModel> updateMovie(@PathVariable Long id, @RequestBody MovieRequestModel movieRequestModel) {
        MovieResponseModel userResponseModel = movieService.updateMovie(id, movieRequestModel);
        return ResponseEntity.ok(userResponseModel);
    }

    @GetMapping(value = "/movie")
    public ResponseEntity<List<MovieResponseModel>> findAll() {
        List<MovieResponseModel> all = movieService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/movie/{id}")
    public ResponseEntity<MovieResponseModel> findById(@PathVariable Long id) {
        MovieResponseModel movieResponseModel = movieService.findById(id);
        return ResponseEntity.ok(movieResponseModel);
    }
    
    @DeleteMapping("/movie/{id}")
    public ResponseEntity<MovieResponseModel> deleteMovie(@PathVariable Long id) {
        MovieResponseModel delete = movieService.deleteMovie(id);
       return ResponseEntity.ok(delete);
    }

}
