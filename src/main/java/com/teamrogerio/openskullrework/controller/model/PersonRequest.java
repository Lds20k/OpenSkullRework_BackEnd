package com.teamrogerio.openskullrework.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonRequest {

    private String name;
    private String lastname;
    private String email;
    private String password;
    private String birth;
    private String institution;
    private String image;
    private String biography;
    private List<String> courses;
}
