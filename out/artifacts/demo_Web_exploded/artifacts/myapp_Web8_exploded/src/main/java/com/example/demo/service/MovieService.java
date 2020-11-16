package com.example.demo.service;

import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.persistance.model.*;
import com.example.demo.persistance.repositories.CommentRepository;
import com.example.demo.rest.models.*;
import com.example.demo.persistance.repositories.MovieRepository;
import com.example.demo.persistance.repositories.ProducerRepository;
import com.example.demo.persistance.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
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
        User user;
        if (userRepository.findById(movieRequestModel.getUser_id()).isPresent()) {
            user= userRepository.findById(movieRequestModel.getUser_id()).get();
        } else {
            throw new ObjectNotFoundException("The user not found");
        }
        movie.setUser(user);

        Producer producer;
        if (producerRepository.findById(movieRequestModel.getProducer_id()).isPresent()) {
            producer = producerRepository.findById(movieRequestModel.getProducer_id()).get();
        } else {
            throw new ObjectNotFoundException("The producer not found");
        }
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
        if (userRepository.findById(movie.getUser().getId()).isPresent()) {
            user= userRepository.findById(movie.getUser().getId()).get();
        } else {
            throw new ObjectNotFoundException("The user not found");
        }
        UserResponseModel userResponseModel= new UserResponseModel();
        userResponseModel.setId(user.getId());
        userResponseModel.setEmail(user.getEmail());
        userResponseModel.setName(user.getName());
        userResponseModel.setUsername(user.getUsername());
        userResponseModel.setPassword(user.getPassword());
        userResponseModel.setComments(commentRepository.findAllByMovie_Id(user.getId()));
        userResponseModel.setMovies(movieRepository.findMoviesByUserId(user.getId()));
        movieResponseModel.setUser(userResponseModel);
        return movieResponseModel;
    }
    public MovieResponseModel createMovie(MovieRequestModel movieRequestModel) {
        Movie movie = requestToMovie(movieRequestModel);
        return movieToResponse(movie);
    }

    public List<MovieResponseModel> findAll() {
        List<Movie> all = movieRepository.findAll();
        return all.stream()
                .map(this::movieToResponse)
                .collect(Collectors.toList());
    }

    public MovieResponseModel findById(Long id) {
        Movie movie;
        if (movieRepository.findById(id).isPresent()) {
            movie=movieRepository.findById(id).get();
        } else {
            throw new ObjectNotFoundException("The movie not found");
        }
        return movieToResponse(movie);
    }

    public MovieResponseModel updateMovie(Long id, MovieRequestModel movieRequestModel) {
        Movie movie;
        if (movieRepository.findById(id).isPresent()) {
            movie=movieRepository.findById(id).get();
        } else {
            throw new ObjectNotFoundException("The movie not found");
        }
        movie.setTitle(movieRequestModel.getTitle());
        movie.setBody(movieRequestModel.getBody());
        User user;
        if (userRepository.findById(movieRequestModel.getUser_id()).isPresent()){
            user = userRepository.findById(movieRequestModel.getUser_id()).get();
        } else {
            throw new ObjectNotFoundException("The user nor found");
        }
        movie.setUser(user);
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
