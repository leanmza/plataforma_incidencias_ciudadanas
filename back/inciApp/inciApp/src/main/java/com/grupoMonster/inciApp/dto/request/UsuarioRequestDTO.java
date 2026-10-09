package com.grupoMonster.inciApp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioRequestDTO {

    @NotNull(message = "El nombre de usuario no puede ser nulo")
    @NotBlank(message = "El nombre de usuario no puede estar en blanco")
    String username;

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar en blanco")
    String name;

    @NotNull(message = "El apellido no puede ser nulo")
    @NotBlank(message = "El apellido no puede estar en blanco")
    String lastname;

    @NotNull(message = "La contraseña no puede ser nula")
    @NotBlank(message = "La contraseña no puede estar en blanco")
    String password;

    @NotNull(message = "El email no puede ser nulo")
    @NotBlank(message = "El email no puede estar en blanco")
    @Email(message = "El email debe tener un formato correcto")
    String email;

    @NotNull(message = "El DNI no puede ser nulo")
    @NotBlank(message = "El DNI no puede estar en blanco")
    String dni;

    @NotNull(message = "El teléfono no puede ser nulo")
    @NotBlank(message = "El teléfono no puede estar en blanco")
    String telefono;

    @NotNull(message = "La dirección no puede ser nula")
    @NotBlank(message = "La dirección no puede estar en blanco")
    String direccion;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    @NotBlank(message = "La fecha de nacimiento no puede estar en blanco")
    LocalDate fechaNacimiento;

    /*
     @NotBlank
     Long idLocalidad;
     @NotBlank
      Long idDepartamento;
     @NotBlank
      Long idProvincia;
    */



}
