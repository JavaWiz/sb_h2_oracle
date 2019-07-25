package com.javawiz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    private String emailId;

}