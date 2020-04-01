package com.teamrogerio.openskullrework.gateway.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

@Document(collection = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDBDomain {
    public static final String AMERICA_SAO_PAULO = "America/Sao_Paulo";
    @Id
    private String id;
    private String creator;
    private String name;
    private String image;
    private String time;
    private String description;
    private String price;
    private List<String> modules;
    private ZoneId zonedId = ZoneId.of(AMERICA_SAO_PAULO);
    private Instant createdAt = LocalDateTime.now().toInstant(OffsetDateTime.now().toLocalDateTime().atZone(zonedId).getOffset());
}
