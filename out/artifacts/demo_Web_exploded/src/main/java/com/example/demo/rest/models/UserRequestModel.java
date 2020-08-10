package com.example.demo.rest.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserRequestModel implements Serializable {
    private String email;
    private String name;
    private String username;
    private String password;

    public UserRequestModel(String email, String name, String username, String password) {
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
