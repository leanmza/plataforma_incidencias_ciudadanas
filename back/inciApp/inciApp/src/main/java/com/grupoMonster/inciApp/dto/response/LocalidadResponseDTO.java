package com.grupoMonster.inciApp.dto.response;

import com.grupoMonster.inciApp.model.Departamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalidadResponseDTO {
    private Long id;

    private String nombre;

    private DepartamentoNombreResponseDTO departamento;
}
