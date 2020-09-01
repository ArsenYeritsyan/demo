package com.example.demo.persistance.repositories;
import com.example.demo.persistance.model.Comment;
import com.example.demo.persistance.model.Movie;
import com.example.demo.persistance.model.Producer;
import com.example.demo.rest.models.CommentResponseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Long> {
    Set<Movie> findMoviesByUserId(Long user_id);
    Optional<Movie> findById(Long movie_id);
}