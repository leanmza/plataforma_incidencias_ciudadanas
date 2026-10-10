package com.grupoMonster.inciApp.mapper;

import com.grupoMonster.inciApp.dto.request.LocalidadRequestDTO;
import com.grupoMonster.inciApp.dto.response.LocalidadResponseDTO;
import com.grupoMonster.inciApp.model.Localidad;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ILocalidadMapper {

    Localidad toLocalidad (LocalidadRequestDTO localidadRequestDTO);

    LocalidadResponseDTO toLocalidadResponse (Localidad localidad);

    List<LocalidadResponseDTO> toListLocalidadResponse (List<Localidad> localidades);


}
