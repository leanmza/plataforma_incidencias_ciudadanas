package com.grupoMonster.inciApp.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioRequestDTO {

    @NotBlank(message = "El nombre de usuario no puede estar en blanco")
    String username;

    @NotBlank(message = "El nombre no puede estar en blanco")
    String name;

    @NotBlank(message = "El apellido no puede estar en blanco")
    String lastname;

    @NotBlank(message = "La contraseña no puede estar en blanco")
    String password;

    @NotBlank(message = "El email no puede estar en blanco")
    @Email(message = "El email debe tener un formato correcto")
    String email;

    @NotBlank(message = "El DNI no puede estar en blanco")
    String dni;

    @NotBlank(message = "El teléfono no puede estar en blanco")
    String telefono;

    @NotBlank(message = "La dirección no puede estar en blanco")
    String direccion;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    @Past(message = "La fecha de nacimiento debe ser anterior a hoy")
    LocalDate fechaNacimiento;

    @NotNull(message = "La localidad no puede ser nula")
    Long idLocalidad;

    @NotNull(message = "El departamento no puede ser nulo")
    Long idDepartamento;

    @NotNull(message = "La provincia no puede ser nula")
    Long idProvincia;


}
