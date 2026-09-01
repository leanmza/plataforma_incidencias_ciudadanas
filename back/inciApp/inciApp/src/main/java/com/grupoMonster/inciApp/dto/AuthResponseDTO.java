package com.grupoMonster.inciApp.dto;

public record AuthResponseDTO(String username, String message, String jwt, boolean status) {
}
