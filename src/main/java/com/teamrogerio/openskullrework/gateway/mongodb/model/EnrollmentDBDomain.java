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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "enrollement")
public class EnrollmentDBDomain {
    public static final String AMERICA_SAO_PAULO = "America/Sao_Paulo";
    @Id
    private String id;
    private PersonDBDomain person;
    private CourseDBDomain course;
    private ZoneId zonedId = ZoneId.of(AMERICA_SAO_PAULO);
    private Instant EnrolledOn = LocalDateTime.now().toInstant(OffsetDateTime.now().toLocalDateTime().atZone(zonedId).getOffset());
}
