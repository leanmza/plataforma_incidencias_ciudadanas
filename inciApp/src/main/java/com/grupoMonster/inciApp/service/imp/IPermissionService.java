package com.grupoMonster.inciApp.service.imp;

import com.grupoMonster.inciApp.dto.request.PermissionRequestDTO;
import com.grupoMonster.inciApp.model.Permission;

import java.util.List;
import java.util.Optional;

public interface IPermissionService {
    List<Permission> findAll();

    Optional<Permission> findById(Long id);

    Permission save(PermissionRequestDTO permission);

    Permission update(Long id, PermissionRequestDTO permission);

    void delete(Long id);
}
