package com.example.demo.persistance.repositories;

import com.example.demo.persistance.model.Comment;
import com.example.demo.persistance.model.Movie;
import com.example.demo.persistance.model.User;
import com.example.demo.rest.models.CommentResponseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends MongoRepository<User,Long> {
    List<Comment> findAllCommentBy_Id(Long user_id);
    Set<Movie> findAllMoviesBy_Id(Long user_id);
    Optional<User> findBy(Long user_id);

}
