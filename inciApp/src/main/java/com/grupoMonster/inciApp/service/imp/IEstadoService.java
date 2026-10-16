package com.grupoMonster.inciApp.service.imp;

import com.grupoMonster.inciApp.dto.request.EstadoRequestDTO;
import com.grupoMonster.inciApp.dto.response.EstadoResponseDTO;
import com.grupoMonster.inciApp.model.Estado;

import java.util.List;

public interface IEstadoService {
    List<EstadoResponseDTO> findAll();

    EstadoResponseDTO findById(Long id);

    EstadoResponseDTO save(EstadoRequestDTO estado);

    EstadoResponseDTO update(Long id, EstadoRequestDTO estado);

    void delete(Long id);

    Estado findByEstado(String estado);

    Estado findEstado(Long id);


}
