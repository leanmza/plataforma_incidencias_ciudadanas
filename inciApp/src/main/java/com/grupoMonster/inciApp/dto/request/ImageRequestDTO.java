package com.grupoMonster.inciApp.dto.request;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grupoMonster.inciApp.model.Incidente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ImageRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String imageUrl;

    @NotBlank
    private String cloudinaryId;

    @NotNull
    private Incidente incidenteId;
}
