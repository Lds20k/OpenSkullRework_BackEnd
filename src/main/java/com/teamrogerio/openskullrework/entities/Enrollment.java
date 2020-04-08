package com.teamrogerio.openskullrework.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enrollment {
    private String id;
    private Person person;
    private Course course;
}
