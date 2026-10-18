package com.grupoMonster.inciApp.service.imp;

import com.grupoMonster.inciApp.dto.response.ImageResponseDTO;
import com.grupoMonster.inciApp.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IImageService {
    List<ImageResponseDTO> findAll();

    ImageResponseDTO findById(Long id);

    ImageResponseDTO save(MultipartFile image) throws IOException;

    void delete(Long id) throws IOException;
}
