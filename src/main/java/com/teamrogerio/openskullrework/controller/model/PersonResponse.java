package com.teamrogerio.openskullrework.controller.model;

import com.teamrogerio.openskullrework.entities.PersonCourse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonResponse {

    private String id;
    private String name;
    private String lastname;
    private String email;
    private String birth;
    private String institution;
    private String image;
    private String biography;
    private Instant createdAt;
    private List<PersonCourse> courses;
}
