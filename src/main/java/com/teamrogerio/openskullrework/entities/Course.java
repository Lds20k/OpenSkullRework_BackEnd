package com.teamrogerio.openskullrework.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {
    private String id;
    private String creator;
    private String name;
    private String image;
    private String time;
    private String description;
    private String price;
    private Instant createdAt;
    private List<Module> modules;
}
