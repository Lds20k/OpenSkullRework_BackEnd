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

@Document(collection = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDBDomain {
    public static final String AMERICA_SAO_PAULO = "America/Sao_Paulo";
    @Id
    private String id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String birth;
    private String institution;
    private String image;
    private String biography;
    private List<String> courses;
    private ZoneId zonedId = ZoneId.of(AMERICA_SAO_PAULO);
    private Instant createdAt = LocalDateTime.now().toInstant(OffsetDateTime.now().toLocalDateTime().atZone(zonedId).getOffset());
}
