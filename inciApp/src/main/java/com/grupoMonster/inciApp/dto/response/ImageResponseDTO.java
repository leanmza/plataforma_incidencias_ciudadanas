package com.grupoMonster.inciApp.dto.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grupoMonster.inciApp.model.Incidente;

public class ImageResponseDTO {


    private Long id;

    private String name;


    private String imageUrl;


    private String cloudinaryId;


    private Incidente incidente;
}
