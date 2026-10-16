package com.grupoMonster.inciApp.mapper;

import com.grupoMonster.inciApp.dto.request.TipoRequestDTO;
import com.grupoMonster.inciApp.dto.response.TipoResponseDTO;
import com.grupoMonster.inciApp.model.Tipo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITipoMapper {

    Tipo toTipo (TipoRequestDTO tipoRequestDTO);

    TipoResponseDTO toTipoResponseDTO (Tipo tipo);

    List<TipoResponseDTO> toListTipoResponse(List<Tipo> tipos);
}
