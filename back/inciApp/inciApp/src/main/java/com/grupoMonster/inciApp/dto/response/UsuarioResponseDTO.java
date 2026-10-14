package com.grupoMonster.inciApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {
    private String id;

    private String username;
    private String name;
    private String lastname;

    private String email;

    private String dni;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;

    private LocalidadNombreResponseDTO localidad;

    private DepartamentoNombreResponseDTO departamento;

    private ProvinciaNombreResponseDTO provincia;

    private boolean enabled;
    private boolean accountNotExpired;
    private boolean accountNotLocked;
    private boolean credentialNotExpired;


}
