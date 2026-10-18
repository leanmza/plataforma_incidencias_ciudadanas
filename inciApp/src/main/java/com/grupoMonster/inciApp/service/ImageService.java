package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.response.ImageResponseDTO;
import com.grupoMonster.inciApp.mapper.IImageMapper;
import com.grupoMonster.inciApp.model.Image;
import com.grupoMonster.inciApp.repository.IImageRepository;
import com.grupoMonster.inciApp.service.imp.ICloudinaryService;
import com.grupoMonster.inciApp.service.imp.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ImageService implements IImageService {

    @Autowired
    private IImageRepository imageRepo;

    @Autowired
    private IImageMapper imageMapper;

    @Autowired
    private ICloudinaryService cloudinaryService;

    @Override
    public List<ImageResponseDTO> findAll() {
        List<Image> images = imageRepo.findAll();
        return imageMapper.toListImageResponse(images);
    }

    @Override
    public ImageResponseDTO findById(Long id) {
        Image image = findImage(id);
        return imageMapper.toImageResponseDTO(image);
    }


    @Override
    public ImageResponseDTO save(MultipartFile multipartFile) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
        if (bufferedImage == null) {
            throw new IOException("Imagen no válida");
        }

        Map result = cloudinaryService.upload(multipartFile);
        Image image = new Image();
        image.setName((String) result.get("original_filename"));
        image.setImageUrl((String) result.get("url"));
        image.setCloudinaryId((String) result.get("public_id"));

        imageRepo.save(image);
        return imageMapper.toImageResponseDTO(image);

    }


    @Override
    public void delete(Long id) throws IOException {
        if(!imageRepo.existsById(id)){
            throw new IOException("No existe la imagen");
        }

        Image image = findImage(id);
        Map result = cloudinaryService.delete(image.getCloudinaryId());
        imageRepo.deleteById(id);
    }

    private Image findImage(Long id) {
        return imageRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada"));
    }

}
