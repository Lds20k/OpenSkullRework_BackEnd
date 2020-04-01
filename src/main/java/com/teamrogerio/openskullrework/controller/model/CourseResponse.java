package com.teamrogerio.openskullrework.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseResponse {

    private String id;
    private String creator;
    private String name;
    private String image;
    private String time;
    private String description;
    private String price;
    private Instant createdAt;
    private List<String> modules;
}
