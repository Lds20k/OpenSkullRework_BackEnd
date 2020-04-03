package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.CourseResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetCourseByIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetCourseByIdUseCase {

    private final GetCourseByIdGateway getCourseByIdGateway;

    public CourseResponse execute(String id) throws CourseDoesNotExistsException {
        return Translator.translate(getCourseByIdGateway.execute(id), CourseResponse.class);
    }
}
