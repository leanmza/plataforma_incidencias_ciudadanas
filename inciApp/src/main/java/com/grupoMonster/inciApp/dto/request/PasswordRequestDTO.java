package com.grupoMonster.inciApp.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PasswordRequestDTO(@NotBlank(message = "Ingresá tu contraseña actual") String currentPassword,
                                 @NotBlank(message = "Ingresá la nueva contraseña")
                                 @Size(min = 8, message = "La nueva contraseña debe tener al menos 8 caracteres") String newPassword) {

}
