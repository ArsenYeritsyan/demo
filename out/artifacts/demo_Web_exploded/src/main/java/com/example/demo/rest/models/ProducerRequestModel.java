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
public class ProducerRequestModel implements Serializable {
    private String name;
    private int age;

    public ProducerRequestModel(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
