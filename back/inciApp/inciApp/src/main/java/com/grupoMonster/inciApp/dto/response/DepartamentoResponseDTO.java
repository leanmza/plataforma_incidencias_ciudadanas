package com.grupoMonster.inciApp.dto.response;

import com.grupoMonster.inciApp.model.Provincia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoResponseDTO {

    private Long id;

    private String nombre;

    private ProvinciaNombreResponseDTO provincia;
}
