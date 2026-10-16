package com.grupoMonster.inciApp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IncidenteRequestDTO {

    @NotBlank(message = "La descripción no puede estar en blanco")
    private String descripcion;

    @NotBlank(message = "La dirección no puede estar en blanco")
    private String direccion;

    @NotNull(message = "La localidad no puede ser nula")
    private Long idLocalidad;

    @NotNull(message = "El departamento no puede ser nulo")
    private Long idDepartamento;

    @NotNull(message = "El tipo no puede ser nulo")
    private Long idTipo;

    @NotBlank(message = "El nombre del usuario no puede estar en blanco")
    private String username;

}
