package com.grupoMonster.inciApp.dto;

import com.grupoMonster.inciApp.model.Permission;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleRequestDTO {
    @NotBlank
    String role;

    @NotEmpty
    List<Long> permissionsList;
}
