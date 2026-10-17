package com.grupoMonster.inciApp.service.imp;

import com.grupoMonster.inciApp.dto.request.EstadoRequestDTO;
import com.grupoMonster.inciApp.dto.request.EstadoUpdateRequestDTO;
import com.grupoMonster.inciApp.dto.request.IncidenteRequestDTO;
import com.grupoMonster.inciApp.dto.request.PrioridadUpdateRequestDTO;
import com.grupoMonster.inciApp.dto.response.IncidenteResponseDTO;

import java.util.List;

public interface IIncidenteService {
    List<IncidenteResponseDTO> findAll();

    IncidenteResponseDTO findById(Long id);

    IncidenteResponseDTO save(IncidenteRequestDTO incidente);

    IncidenteResponseDTO update(Long id, IncidenteRequestDTO incidente);

    void delete(Long id);

    IncidenteResponseDTO updateEstado(Long id, EstadoUpdateRequestDTO estadoRequestDTO);

    IncidenteResponseDTO updatePrioridad(Long id, PrioridadUpdateRequestDTO prioridadRequestDTO);

    List<IncidenteResponseDTO> findIncidentesByUserId(String id);
}
