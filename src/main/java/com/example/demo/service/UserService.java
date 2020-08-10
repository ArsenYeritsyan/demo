package com.example.demo.service;
import com.example.demo.persistance.model.User;
import com.example.demo.persistance.repositories.CommentRepository;
import com.example.demo.persistance.repositories.UserRepository;
import com.example.demo.rest.models.UserRequestModel;
import com.example.demo.rest.models.UserResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public UserService(UserRepository userRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    private User requestToUser(UserRequestModel userRequestModel) {
        User user = new User();
        user.setEmail(userRequestModel.getEmail());
        user.setName(userRequestModel.getName());
        user.setUsername(userRequestModel.getUsername());
        user.setPassword(userRequestModel.getPassword());
        return user;
    }

    private UserResponseModel userToResponse(User user) {
        UserResponseModel userResponseModel = new UserResponseModel();
        userResponseModel.setId(user.getId());
        userResponseModel.setEmail(user.getEmail());
        userResponseModel.setName(user.getName());
        userResponseModel.setUsername(user.getUsername());
        userResponseModel.setPassword(user.getPassword());
        userResponseModel.setComments(commentRepository.findAllByUser_Id(user.getId()));
        userResponseModel.setMovies(userRepository.findAllMoviesBy_Id(user.getId()));
        return userResponseModel;
    }

    public UserResponseModel createUser(UserRequestModel userRequestModel) {
        User user = requestToUser(userRequestModel);
        userRepository.save(user);
        return userToResponse(user);
    }

    public List<UserResponseModel> findAll() {
        List<User> all = userRepository.findAll();
        return all.stream()
                .map(this::userToResponse)
                .collect(Collectors.toList());
    }

    public UserResponseModel findById(Long id){
        User user = userRepository.findById(id).get();
        return userToResponse(user);
    }

    public UserResponseModel updateUser(Long id , UserRequestModel userRequestModel){
        User user = userRepository.findById(id).get();
        user.setEmail(userRequestModel.getEmail());
        user.setName(userRequestModel.getName());
        user.setUsername(userRequestModel.getUsername());
        user.setPassword(userRequestModel.getPassword());
        userRepository.save(user);
        return userToResponse(user);
    }
    public UserResponseModel deleteUser(Long id){
        userRepository.deleteById(id);
        return null;
    }

}
