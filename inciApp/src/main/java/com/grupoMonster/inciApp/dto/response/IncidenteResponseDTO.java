package com.grupoMonster.inciApp.dto.response;

import com.grupoMonster.inciApp.model.Image;

import java.time.LocalDate;
import java.util.List;

public record IncidenteResponseDTO(Long id,
                                   TipoResponseDTO tipo,
                                   String descripcion,
                                   String direccion,
                                   LocalDate fecha,
                                   EstadoResponseDTO estado,
                                   PrioridadResponseDTO prioridad,
                                   LocalidadNombreResponseDTO localidad,
                                   DepartamentoNombreResponseDTO departamento,
                                   UsuarioResponseDTO usuario,
                                   List<ImageResponseDTO> images) {
}
