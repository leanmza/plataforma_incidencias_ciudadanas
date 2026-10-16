package com.grupoMonster.inciApp.mapper;

import com.grupoMonster.inciApp.dto.request.DepartamentoRequestDTO;
import com.grupoMonster.inciApp.dto.response.DepartamentoResponseDTO;
import com.grupoMonster.inciApp.model.Departamento;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDepartamentoMapper {

    Departamento toDepartamento (DepartamentoRequestDTO departamentoRequestDTO);

    DepartamentoResponseDTO toDepartamentoResponse (Departamento departamento);

    List<DepartamentoResponseDTO> toListDepartamentoResponse (List<Departamento> departamentos);

}
