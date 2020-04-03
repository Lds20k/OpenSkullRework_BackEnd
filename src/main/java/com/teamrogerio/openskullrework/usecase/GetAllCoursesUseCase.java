package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.model.CourseResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetAllCoursesGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class GetAllCoursesUseCase {

    private final GetAllCoursesGateway getAllCoursesGateway;

    public List<CourseResponse> execute(int page){
        return getAllCoursesGateway.execute(page).getContent().stream().map(courseDBDomain -> Translator.translate(courseDBDomain, CourseResponse.class)).collect(Collectors.toList());
    }
}
