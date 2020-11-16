package com.example.demo.service;

import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.persistance.model.Comment;
import com.example.demo.persistance.model.Movie;
import com.example.demo.persistance.model.User;
import com.example.demo.rest.models.CommentRequestModel;
import com.example.demo.rest.models.CommentResponseModel;
import com.example.demo.rest.models.MovieResponseModel;
import com.example.demo.rest.models.UserResponseModel;
import com.example.demo.persistance.repositories.CommentRepository;
import com.example.demo.persistance.repositories.MovieRepository;
import com.example.demo.persistance.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

        private final CommentRepository commentRepository;
        private final UserRepository userRepository;
        private final MovieRepository movieRepository;

        public CommentService(CommentRepository commentRepository, UserRepository userRepository, MovieRepository movieRepository) {
            this.commentRepository = commentRepository;
            this.userRepository = userRepository;
            this.movieRepository = movieRepository;
        }

        private Comment requestToComment(CommentRequestModel commentRequestModel) {
            Comment comment = new Comment();
            User user;
            if (userRepository.findById(commentRequestModel.getUser_id()).isPresent()) {
                user= userRepository.findById(commentRequestModel.getUser_id()).get();
            } else {
                throw new ObjectNotFoundException("The user not found");
            }

            comment.setUser(user);
            comment.setBody(commentRequestModel.getBody());
            Movie movie;
            if (movieRepository.findById(commentRequestModel.getMovie_id()).isPresent()) {
                movie = movieRepository.findById(commentRequestModel.getMovie_id()).get();
            } else {
                throw new ObjectNotFoundException("The movie not found");
            }
            comment.setMovie(movie);
            return comment;
        }

        private CommentResponseModel commentToResponse(Comment comment) {
            CommentResponseModel commentResponseModel = new CommentResponseModel();
            commentResponseModel.setId(comment.getId());
            commentResponseModel.setBody(comment.getBody());
            UserResponseModel userResponseModel = new UserResponseModel();
            User user;
            if (userRepository.findById(comment.getUser().getId()).isPresent()) {
                user = userRepository.findById(comment.getUser().getId()).get();
            } else {
                throw new ObjectNotFoundException("The user nor found");
            }
            userResponseModel.setId(user.getId());
            userResponseModel.setName(user.getName());
            commentResponseModel.setUserResponseModel(userResponseModel);
            Movie movie;
            if (movieRepository.findById(comment.getMovie().getId()).isPresent()) {
                movie=movieRepository.findById(comment.getMovie().getId()).get();
            } else {
                throw new ObjectNotFoundException("The movie not found");
            }
            MovieResponseModel movieResponseModel=new MovieResponseModel();
            movieResponseModel.setId(movie.getId());
            movieResponseModel.setTitle(movie.getTitle());
            commentResponseModel.setMovieResponseModel(movieResponseModel);
            return commentResponseModel;
        }

        public CommentResponseModel createComment(CommentRequestModel commentRequestModel) {
            Comment comment = requestToComment(commentRequestModel);
            commentRepository.save(comment);
            return commentToResponse(comment);
        }

        public CommentResponseModel updateComment(Long id, CommentRequestModel commentRequestModel) {
            Comment comment;
            if (commentRepository.findById(id).isPresent()) {
                comment = commentRepository.findById(id).get();
            } else {
                throw new ObjectNotFoundException("The user nor found");
            }
            comment.setBody(commentRequestModel.getBody());
            commentRepository.save(comment);
            return commentToResponse(comment);
        }
    public CommentResponseModel findById(Long id){
        Comment comment;
        if (commentRepository.findById(id).isPresent()) {
            comment = commentRepository.findById(id).get();
        } else {
            throw new ObjectNotFoundException("The user nor found");
        }
        return commentToResponse(comment);
    }
    public List<CommentResponseModel> findAll(){
        List<Comment> all = commentRepository.findAll();
        return all.stream()
                .map(this::commentToResponse)
                .collect(Collectors.toList());
    }
    public CommentResponseModel deleteComment(Long id){
       commentRepository.deleteById(id);
       return null;
    }

}
