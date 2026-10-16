package com.grupoMonster.inciApp.mapper;

import com.grupoMonster.inciApp.dto.request.ProvinciaRequestDTO;
import com.grupoMonster.inciApp.dto.response.ProvinciaNombreResponseDTO;
import com.grupoMonster.inciApp.dto.response.ProvinciaResponseDTO;
import com.grupoMonster.inciApp.model.Provincia;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProvinciaMapper {

    Provincia toProvincia (ProvinciaRequestDTO provinciaRequestDTO);

    ProvinciaResponseDTO toProvinciaResponseDTO (Provincia provincia);

    List<ProvinciaResponseDTO> toListProvinciaResponse (List<Provincia> provincias);

}
