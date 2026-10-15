package com.grupoMonster.inciApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


public record UsuarioResponseDTO(String id,
                                 String username,
                                 String name,
                                 String lastname,
                                 String email,
                                 String dni,
                                 String telefono,
                                 String direccion,
                                 LocalDate fechaNacimiento,
                                 LocalidadNombreResponseDTO localidad,
                                 DepartamentoNombreResponseDTO departamento,
                                 ProvinciaNombreResponseDTO provincia,
                                 boolean enabled,
                                 boolean accountNotExpired,
                                 boolean accountNotLocked,
                                 boolean credentialNotExpired) {
}
