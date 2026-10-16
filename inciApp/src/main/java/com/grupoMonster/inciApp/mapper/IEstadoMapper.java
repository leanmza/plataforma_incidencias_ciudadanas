package com.grupoMonster.inciApp.mapper;

import com.grupoMonster.inciApp.dto.request.EstadoRequestDTO;
import com.grupoMonster.inciApp.dto.response.EstadoResponseDTO;
import com.grupoMonster.inciApp.model.Estado;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEstadoMapper {

    Estado toEstado (EstadoRequestDTO estadoRequestDTO);

    EstadoResponseDTO toEstadoResponseDTO (Estado estado);

    List<EstadoResponseDTO> toListEstadoResponse (List<Estado> estados);
}
