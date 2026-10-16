package com.grupoMonster.inciApp.dto.response;

import com.grupoMonster.inciApp.model.Departamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public record LocalidadResponseDTO (Long id, String nombre, DepartamentoNombreResponseDTO departamento) {
/*    private Long id;

    private String nombre;

    private DepartamentoNombreResponseDTO departamento;*/
}
