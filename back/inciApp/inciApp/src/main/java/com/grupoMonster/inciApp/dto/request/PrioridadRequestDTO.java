package com.grupoMonster.inciApp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrioridadRequestDTO  {

    @NotBlank(message = "La prioridad no puede estar en blanco")
    @NotEmpty(message = "La prioridad no puede estar vacia")
    private String prioridad;
}
