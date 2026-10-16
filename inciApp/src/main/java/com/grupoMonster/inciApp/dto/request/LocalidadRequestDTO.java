package com.grupoMonster.inciApp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocalidadRequestDTO {

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotNull(message = "Debe seleccionar un departamento")
    private Long departamentoId;
}
