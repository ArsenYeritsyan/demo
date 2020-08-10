package com.example.demo.service;

import com.example.demo.persistance.model.*;
import com.example.demo.persistance.repositories.CommentRepository;
import com.example.demo.rest.models.*;
import com.example.demo.persistance.repositories.MovieRepository;
import com.example.demo.persistance.repositories.ProducerRepository;
import com.example.demo.persistance.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class MovieService {


    private final MovieRepository movieRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ProducerRepository producerRepository;

    public MovieService(MovieRepository movieRepository, UserRepository userRepository, CommentRepository commentRepository, ProducerRepository producerRepository) {
        this.movieRepository = movieRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.producerRepository = producerRepository;
    }

    private Movie requestToMovie(MovieRequestModel movieRequestModel) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestModel.getTitle());
        movie.setBody(movieRequestModel.getBody());
        movie.setDuration(movieRequestModel.getDuration());
        User user = userRepository.findById(movieRequestModel.getUser_id()).get();
        movie.setUser(user);
        Producer producer= producerRepository.findById(movieRequestModel.getProducer_id()).get();
        movie.addProducer(producer);
        return movie;
    }

    private MovieResponseModel movieToResponse(Movie movie) {
        MovieResponseModel movieResponseModel = new MovieResponseModel();
        movieResponseModel.setId(movie.getId());
        movieResponseModel.setTitle(movie.getTitle());
        movieResponseModel.setBody(movie.getBody());
        Set<ProducerResponseModel> allByMovies = producerRepository.findAllByMovies(movie.getId()).stream()
                .map(this::toResponse)
                .collect(Collectors.toSet());
        movieResponseModel.setProducers(allByMovies);
        movieResponseModel.setId(movie.getId());
        User user;
        user = userRepository.findById(movie.getUser().getId()).get();
        UserResponseModel userResponseModel= new UserResponseModel();
        userResponseModel.setId(user.getId());
        userResponseModel.setEmail(user.getEmail());
        userResponseModel.setName(user.getName());
        userResponseModel.setUsername(user.getUsername());
        userResponseModel.setPassword(user.getPassword());
        userResponseModel.setComments(commentRepository.findAllByMovie_Id(user.getId()));
        userResponseModel.setMovies(userRepository.findAllMoviesBy_Id(user.getId()));
        movieResponseModel.setUser(userResponseModel);
        return movieResponseModel;
    }
    public MovieResponseModel createMovie(MovieRequestModel movieRequestModel) {
        Movie movie = requestToMovie(movieRequestModel);
        movieRepository.save(movie);
        return movieToResponse(movie);
    }

    public List<MovieResponseModel> findAll() {
        List<Movie> all = movieRepository.findAll();
        return all.stream()
                .map(this::movieToResponse)
                .collect(Collectors.toList());
    }

    public MovieResponseModel findById(Long id) {
        Movie movie = movieRepository.findById(id).get();
        return movieToResponse(movie);
    }

    public MovieResponseModel updateMovie(Long id, MovieRequestModel movieRequestModel) {
        Movie movie = movieRepository.findById(id).get();
        movie.setTitle(movieRequestModel.getTitle());
        movie.setBody(movieRequestModel.getBody());
        movie.setUser(userRepository.findById(movieRequestModel.getUser_id()).get());
        movieRepository.save(movie);
        return movieToResponse(movie);
    }

    public MovieResponseModel deleteMovie(Long id) {
        movieRepository.deleteById(id);
        return null;
    }

    private ProducerResponseModel toResponse(Producer producer){
        ProducerResponseModel responseModel= new ProducerResponseModel();
        responseModel.setId(producer.getId()) ;
        responseModel.setName(producer.getName());
        responseModel.setAge(producer.getAge()) ;
        return responseModel;
    }
}
