package com.grupoMonster.inciApp.mapper;

import com.grupoMonster.inciApp.dto.request.IncidenteRequestDTO;
import com.grupoMonster.inciApp.dto.response.IncidenteResponseDTO;
import com.grupoMonster.inciApp.model.Incidente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IIncidenteMapper {

    Incidente toIncidente (IncidenteRequestDTO incidenteRequestDTO);

    IncidenteResponseDTO toIncidenteResponseDTO (Incidente incidente);

    List<IncidenteResponseDTO> toListIncidenteResponse (List<Incidente> incidentes);
}
