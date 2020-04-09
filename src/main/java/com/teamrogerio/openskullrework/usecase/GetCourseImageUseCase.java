package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.exception.ProblemsToLoadImageException;
import com.teamrogerio.openskullrework.controller.model.ImageResponse;
import com.teamrogerio.openskullrework.gateway.mongodb.model.CourseDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetCourseByIdGateway;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;

@RequiredArgsConstructor
@Component
public class GetCourseImageUseCase {

    private final GetCourseByIdGateway getCourseByIdGateway;

    public ImageResponse execute(String courseId) throws CourseDoesNotExistsException, ProblemsToLoadImageException {
        CourseDBDomain courseDBDomain = getCourseByIdGateway.execute(courseId);
        File file;
        if (courseDBDomain.getImage() != null) {
            file = new File(new File("public\\images\\course\\" + courseDBDomain.getImage()).getAbsolutePath());
        } else {
            file = new File(new File("public\\images\\user\\default.png").getAbsolutePath());
        }

        byte[] bytes = new byte[(int) file.length()];
        try {
            new FileInputStream(file).read(bytes);
        } catch (Exception e) {
            throw new ProblemsToLoadImageException("Problem to load the image");
        }
        return new ImageResponse(new String(Base64.encodeBase64(bytes)));
    }
}
