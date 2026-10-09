package com.grupoMonster.inciApp.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioUpdateRequestDTO {
    String name;

    String lastname;

    String password;

    String email;

    String dni;

    String telefono;


    String direccion;


    LocalDate fechaNacimiento;
}
