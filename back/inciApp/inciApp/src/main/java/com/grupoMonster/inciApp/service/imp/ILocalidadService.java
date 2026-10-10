package com.grupoMonster.inciApp.service.imp;

import com.grupoMonster.inciApp.dto.request.LocalidadRequestDTO;
import com.grupoMonster.inciApp.dto.response.LocalidadResponseDTO;

import java.util.List;

public interface ILocalidadService {
    List<LocalidadResponseDTO> findAll();

    LocalidadResponseDTO findById(Long id);

    LocalidadResponseDTO save(LocalidadRequestDTO localidad);

    LocalidadResponseDTO update(Long id, LocalidadRequestDTO localidad);

    void delete(Long id);
}
