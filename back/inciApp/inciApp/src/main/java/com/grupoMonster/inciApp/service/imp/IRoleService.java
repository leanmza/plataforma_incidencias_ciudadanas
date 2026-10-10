package com.grupoMonster.inciApp.service.imp;

import com.grupoMonster.inciApp.dto.request.RoleRequestDTO;
import com.grupoMonster.inciApp.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List<Role> findAll();

    Optional<Role> findById(Long id);

    Role save(RoleRequestDTO roleDTO);

    Role update(Long id, RoleRequestDTO roleDTO);

    void delete(Long id);

    Optional<Role> findByName(String defaultRole);
}
