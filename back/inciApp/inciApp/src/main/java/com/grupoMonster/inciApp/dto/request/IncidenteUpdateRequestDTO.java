package com.grupoMonster.inciApp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncidenteUpdateRequestDTO {

    private String descripcion;

    private String direccion;

    private Long idLocalidad;

    private Long idDepartamento;

    private Long idTipo;

}
