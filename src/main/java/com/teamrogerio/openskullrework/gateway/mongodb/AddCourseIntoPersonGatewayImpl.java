package com.teamrogerio.openskullrework.gateway.mongodb;

import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Enrollment;
import com.teamrogerio.openskullrework.gateway.mongodb.model.EnrollmentDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.AddCourseIntoPersonGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.EnrollmentRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddCourseIntoPersonGatewayImpl implements AddCourseIntoPersonGateway {

    private final EnrollmentRespository enrollmentRespository;

    @Override
    public EnrollmentDBDomain execute(Enrollment enrollment) {
        return enrollmentRespository.save(Translator.translate(enrollment, EnrollmentDBDomain.class));
    }
}
