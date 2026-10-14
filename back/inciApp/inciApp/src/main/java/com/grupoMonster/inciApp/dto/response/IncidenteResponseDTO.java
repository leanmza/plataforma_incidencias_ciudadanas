package com.grupoMonster.inciApp.dto.response;

import java.time.LocalDate;

public record IncidenteResponseDTO(Long id,
                                   TipoResponseDTO tipo,
                                   String descripcion,
                                   String direccion,
                                   LocalDate fecha,
                                   EstadoResponseDTO estado,
                                   PrioridadResponseDTO prioridad,
                                   LocalidadNombreResponseDTO localidad,
                                   DepartamentoNombreResponseDTO departamento,
                                   UsuarioResponseDTO usuario) {
}
