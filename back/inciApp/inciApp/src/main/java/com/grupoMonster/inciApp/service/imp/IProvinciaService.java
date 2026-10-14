package com.grupoMonster.inciApp.service.imp;

import com.grupoMonster.inciApp.dto.request.ProvinciaRequestDTO;
import com.grupoMonster.inciApp.dto.response.ProvinciaResponseDTO;
import com.grupoMonster.inciApp.model.Provincia;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public interface IProvinciaService {
    List<ProvinciaResponseDTO> findAll();

    ProvinciaResponseDTO findById(Long id);

    ProvinciaResponseDTO save(ProvinciaRequestDTO provinciaRequestDTO);

    ProvinciaResponseDTO update(Long id, ProvinciaRequestDTO provinciaRequestDTO);

    void delete(Long id);

    Provincia findProvincia(Long idProvincia);
}
