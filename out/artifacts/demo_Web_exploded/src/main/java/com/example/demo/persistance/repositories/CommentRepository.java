package com.example.demo.persistance.repositories;

import com.example.demo.persistance.model.Comment;
import com.example.demo.rest.models.CommentResponseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CommentRepository extends MongoRepository<Comment,Long> {
    List<Comment> findAllByMovie_Id(Long movie_id);
    List<Comment> findAllByUser_Id(Long user_id);

}
