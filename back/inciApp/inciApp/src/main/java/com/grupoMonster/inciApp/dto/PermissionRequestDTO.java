package com.grupoMonster.inciApp.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record PermissionRequestDTO(@NotBlank String permission) {
}
