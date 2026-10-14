package com.grupoMonster.inciApp.service.imp;

import com.grupoMonster.inciApp.dto.request.TipoRequestDTO;
import com.grupoMonster.inciApp.dto.response.TipoResponseDTO;
import com.grupoMonster.inciApp.model.Tipo;

import java.util.List;

public interface ITipoService {
    List<TipoResponseDTO> findAll();

    TipoResponseDTO findById(Long id);

    TipoResponseDTO save(TipoRequestDTO tipo);

    TipoResponseDTO update(Long id, TipoRequestDTO tipo);

    void delete(Long id);

    Tipo findTipo(Long id);
}
