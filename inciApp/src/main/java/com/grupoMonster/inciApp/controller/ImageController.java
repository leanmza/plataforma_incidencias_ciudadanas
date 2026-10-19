package com.grupoMonster.inciApp.controller;

import com.grupoMonster.inciApp.dto.response.ImageResponseDTO;
import com.grupoMonster.inciApp.service.imp.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private IImageService imageService;

    @GetMapping
    public ResponseEntity<List> getAllImages(){
        List<ImageResponseDTO> images = imageService.findAll();
        return ResponseEntity.ok(images);
    }

    @GetMapping("/{id}")
    public ResponseEntity getImageById(@PathVariable Long id){
        ImageResponseDTO image = imageService.findById(id);
        return ResponseEntity.ok(image);
    }

    @PostMapping
    public ResponseEntity uploadImage(@RequestParam("image")MultipartFile multipartFile) throws IOException{
        ImageResponseDTO image = imageService.save(multipartFile);
        return ResponseEntity.ok(image);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteImage(@PathVariable Long id) throws IOException{
        imageService.delete(id);
        return ResponseEntity.ok("Imagen eliminada exitosamente");
    }
}
