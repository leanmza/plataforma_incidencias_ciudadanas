package com.grupoMonster.inciApp.service.imp;

import com.grupoMonster.inciApp.dto.request.DepartamentoRequestDTO;
import com.grupoMonster.inciApp.dto.response.DepartamentoResponseDTO;
import com.grupoMonster.inciApp.model.Departamento;

import java.util.List;

public interface IDepartamentoService {
    List<DepartamentoResponseDTO> findAll();

    DepartamentoResponseDTO findById(Long id);

    DepartamentoResponseDTO save(DepartamentoRequestDTO departamentoRequestDTO);

    DepartamentoResponseDTO update(Long id, DepartamentoRequestDTO departamentoRequestDTO);

    void delete(Long id);

    Departamento findDepartamento(Long id);
}
