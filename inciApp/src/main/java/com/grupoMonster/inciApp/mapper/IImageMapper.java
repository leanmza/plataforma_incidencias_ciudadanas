package com.grupoMonster.inciApp.mapper;

import com.grupoMonster.inciApp.dto.request.ImageRequestDTO;
import com.grupoMonster.inciApp.dto.response.ImageResponseDTO;
import com.grupoMonster.inciApp.model.Image;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IImageMapper {

    Image toImage (ImageRequestDTO imageRequestDTO);

    ImageResponseDTO toImageResponseDTO (Image image);

    List<ImageResponseDTO> toListImageResponse (List<Image> images);

    Image toImageFromResponse (ImageResponseDTO imageResponseDTO);
}
