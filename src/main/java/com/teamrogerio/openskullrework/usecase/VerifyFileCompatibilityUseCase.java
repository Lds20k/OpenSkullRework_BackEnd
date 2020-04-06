package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.FileIsNotCompatibleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Component
public class VerifyFileCompatibilityUseCase {

    public void execute(MultipartFile file) throws FileIsNotCompatibleException {
        if (!file.getContentType().contains("image/"))
            throw new FileIsNotCompatibleException("The file is not compatible");
    }
}
