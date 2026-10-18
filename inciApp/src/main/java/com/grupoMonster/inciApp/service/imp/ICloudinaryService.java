package com.grupoMonster.inciApp.service.imp;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ICloudinaryService {
    Map upload(MultipartFile multipartFile) throws IOException;

    Map delete(String cloudinaryId) throws IOException;
}
