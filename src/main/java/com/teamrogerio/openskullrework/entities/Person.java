package com.teamrogerio.openskullrework.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private String id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String birth;
    private String institution;
    private String image;
    private String biography;
    private List<PersonCourse> courses;
}
