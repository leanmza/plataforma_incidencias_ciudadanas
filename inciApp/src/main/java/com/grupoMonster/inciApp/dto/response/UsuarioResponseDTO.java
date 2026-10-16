package com.grupoMonster.inciApp.dto.response;

import com.grupoMonster.inciApp.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


public record UsuarioResponseDTO(String id,
                                 String username,
                                 Set<Role> rolesList,
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
