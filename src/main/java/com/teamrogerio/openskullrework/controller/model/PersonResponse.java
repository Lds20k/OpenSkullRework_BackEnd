package com.teamrogerio.openskullrework.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

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
}
