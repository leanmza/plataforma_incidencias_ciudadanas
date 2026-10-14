package com.grupoMonster.inciApp.service.imp;

import com.grupoMonster.inciApp.dto.request.PrioridadRequestDTO;
import com.grupoMonster.inciApp.dto.response.PrioridadResponseDTO;
import com.grupoMonster.inciApp.model.Prioridad;

import java.util.List;

public interface IPrioridadService {
    List<PrioridadResponseDTO> findAll();

    PrioridadResponseDTO findById(Long id);

    PrioridadResponseDTO save(PrioridadRequestDTO prioridad);

    PrioridadResponseDTO update(Long id, PrioridadRequestDTO prioridad);

    void delete(Long id);

    Prioridad findByPrioridad(String prioridad);

    Prioridad findPrioridad(Long id);
}
