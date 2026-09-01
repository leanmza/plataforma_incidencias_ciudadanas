package com.grupoMonster.inciApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter

public class UsuarioRequestDTO {

    @NotBlank
    String username;
    @NotBlank
    String name;
    @NotBlank
    String lastname;
    @NotBlank
    String password;
    @NotBlank
    String email;
    @NotBlank
    String dni;
    @NotBlank
    String telefono;
    @NotBlank
    String direccion;
    @NotBlank
    LocalDate fechaNacimiento;
    /*
     @NotBlank
     Long idLocalidad;
     @NotBlank
      Long idDepartamento;
     @NotBlank
      Long idProvincia;
    */
    @NotEmpty
    List<Long> rolesList;


}
