package com.example.demo.service;

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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
            Optional<User> user =userRepository.findById(commentRequestModel.getUser_id());
            comment.setUser(user.get());
            comment.setBody(commentRequestModel.getBody());
            Optional<Movie> movie = movieRepository.findById(commentRequestModel.getMovie_id());
            comment.setMovie(movie.get());
            return comment;
        }

        private CommentResponseModel commentToResponse(Comment comment) {
            CommentResponseModel commentResponseModel = new CommentResponseModel();
            commentResponseModel.setId(comment.getId());
            commentResponseModel.setBody(comment.getBody());
            UserResponseModel userResponseModel = new UserResponseModel();
            User user = userRepository.findById(comment.getUser().getId()).get();
            userResponseModel.setId(user.getId());
            userResponseModel.setName(user.getName());
            commentResponseModel.setUserResponseModel(userResponseModel);
            Movie movie=movieRepository.findById(comment.getMovie().getId()).get();
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
            Comment comment = commentRepository.findById(id).get();
            comment.setBody(commentRequestModel.getBody());
            commentRepository.save(comment);
            return commentToResponse(comment);
        }
    public CommentResponseModel findById(Long id){
       Comment comment = commentRepository.findById(id).get();
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
