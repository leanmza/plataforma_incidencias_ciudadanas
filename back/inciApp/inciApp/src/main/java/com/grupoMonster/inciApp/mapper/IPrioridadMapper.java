package com.grupoMonster.inciApp.mapper;

import com.grupoMonster.inciApp.dto.request.PrioridadRequestDTO;
import com.grupoMonster.inciApp.dto.response.PrioridadResponseDTO;
import com.grupoMonster.inciApp.model.Prioridad;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPrioridadMapper {

    Prioridad toPrioridad (PrioridadRequestDTO prioridadRequestDTO);

    PrioridadResponseDTO toPrioridadResponseDTO (Prioridad prioridad);

    List<PrioridadResponseDTO> toListPrioridadResponse (List<Prioridad> prioridades);
}
