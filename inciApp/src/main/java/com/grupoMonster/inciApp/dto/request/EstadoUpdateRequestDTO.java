package com.grupoMonster.inciApp.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoUpdateRequestDTO {

    @NotNull(message = "El id de estado no puede ser nulo")
    private Long idEstado;
}
