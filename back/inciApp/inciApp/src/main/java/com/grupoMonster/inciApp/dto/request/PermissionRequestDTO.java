package com.grupoMonster.inciApp.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PermissionRequestDTO(@NotBlank String permission) {
}
