package com.grupoMonster.inciApp.dto.response;

public record AuthResponseDTO(String username, String message, String jwt, boolean status) {
}
