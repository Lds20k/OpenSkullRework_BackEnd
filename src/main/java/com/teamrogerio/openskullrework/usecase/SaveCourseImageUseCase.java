package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.exception.FileIsNotCompatibleException;
import com.teamrogerio.openskullrework.controller.exception.ProblemsToUploadImageException;
import com.teamrogerio.openskullrework.controller.model.CourseResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Course;
import com.teamrogerio.openskullrework.gateway.mongodb.model.CourseDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetCourseByIdGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.UpdateCourseGateway;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@RequiredArgsConstructor
@Component
public class SaveCourseImageUseCase {

    private final GetCourseByIdGateway getCourseByIdGateway;
    private final VerifyFileCompatibilityUseCase verifyFileCompatibilityUseCase;
    private final UpdateCourseGateway updateCourseGateway;

    public CourseResponse execute(String courseId, MultipartFile imageFile) throws CourseDoesNotExistsException, FileIsNotCompatibleException, ProblemsToUploadImageException {
        CourseDBDomain courseDBDomain = getCourseByIdGateway.execute(courseId);

        verifyFileCompatibilityUseCase.execute(imageFile);

        String imgName = (courseDBDomain.getId() + "." + FilenameUtils.getExtension(imageFile.getOriginalFilename()));
        try {
            Files.write(Paths.get((new File("public\\images\\course\\" + imgName).getAbsolutePath())), imageFile.getBytes());
        } catch (Exception e) {
            throw new ProblemsToUploadImageException("Problem to upload the image");
        }
        courseDBDomain.setImage(imgName);

        return Translator.translate(updateCourseGateway.execute(Translator.translate(courseDBDomain, Course.class)), CourseResponse.class);
    }
}