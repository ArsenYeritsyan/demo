package com.example.demo.rest.controllers;

import com.example.demo.rest.models.UserRequestModel;
import com.example.demo.rest.models.UserResponseModel;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping(value = "/user")
    public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel) {
        UserResponseModel user = userService.createUser(userRequestModel);
        return ResponseEntity.ok(user);
    }

    @PutMapping(value = "/user/{id}")
    public ResponseEntity<UserResponseModel> updateUser(@PathVariable Long id, @RequestBody UserRequestModel userRequestModel) {
        UserResponseModel userResponseModel = userService.updateUser(id, userRequestModel);
        return ResponseEntity.ok(userResponseModel);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<UserResponseModel>> findAll() {
        List<UserResponseModel> all = userService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<UserResponseModel> findById(@PathVariable Long id) {
        UserResponseModel userResponseModel = userService.findById(id);
        return ResponseEntity.ok(userResponseModel);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<UserResponseModel> deleteUser(@PathVariable Long id) {
       UserResponseModel delete = userService.deleteUser(id);
       return ResponseEntity.ok(delete);
    }

}
