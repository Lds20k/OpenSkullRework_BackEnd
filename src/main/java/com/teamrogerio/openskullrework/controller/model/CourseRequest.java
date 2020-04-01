package com.teamrogerio.openskullrework.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseRequest {

    private String creator;
    private String name;
    private String image;
    private String time;
    private String description;
    private String price;
    private List<String> modules;
}
