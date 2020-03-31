package com.teamrogerio.openskullrework.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonResponse {

    private String id;
    private String name;
    private String lastname;
    private String email;
}
