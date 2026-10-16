package com.grupoMonster.inciApp.dto.response;

import com.grupoMonster.inciApp.model.Departamento;

import java.util.List;

public record ProvinciaResponseDTO(Long id, String nombre, List<DepartamentoNombreResponseDTO> departamentos) {
}
