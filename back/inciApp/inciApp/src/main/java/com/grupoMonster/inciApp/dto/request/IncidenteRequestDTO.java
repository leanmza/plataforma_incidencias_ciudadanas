package com.grupoMonster.inciApp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IncidenteRequestDTO {

    @NotBlank(message = "La descripción no puede estar en blanco")
    @NotEmpty(message = "La dirección no puede estar vacía")
    private String descripcion;

    @NotBlank(message = "La dirección no puede estar en blanco")
    @NotEmpty(message = "La dirección no puede estar vacía")
    private String direccion;

    @NotEmpty(message = "La localidad no puede estar vacía")
    @NotNull(message = "La localidad no puede ser nula")
    private Long idLocalidad;

    @NotEmpty(message = "El departamento no puede estar vacío")
    @NotNull(message = "El departamento no puede ser nulo")
    private Long idDepartamento;

    @NotEmpty(message = "El tipo no puede estar vacío")
    @NotNull(message = "El tipo no puede ser nulo")
    private Long idTipo;

    @NotEmpty(message = "El nombre del usuario no puede estar vacío")
    @NotNull(message = "El nombre del usuario no puede ser nulo")
    private String username;

}
