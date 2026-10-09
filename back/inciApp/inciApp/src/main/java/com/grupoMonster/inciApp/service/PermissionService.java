package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.request.PermissionRequestDTO;
import com.grupoMonster.inciApp.model.Permission;
import com.grupoMonster.inciApp.repository.IPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService implements IPermissionService {
    @Autowired
    private IPermissionRepository permissionRepo;

    @Override
    public List<Permission> findAll() {
        return permissionRepo.findAll();
    }

    @Override
    public Optional<Permission> findById(Long id) {
        return permissionRepo.findById(id);
    }

    @Override
    public Permission save(PermissionRequestDTO permissionDTO) {
        Permission permission = new Permission();
        permission.setPermission(permissionDTO.permission());
        return permissionRepo.save(permission);
    }

    @Override
    public Permission update(Long id, PermissionRequestDTO permissionDTO) {
        Permission updatedPermission = findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));
        updatedPermission.setPermission(permissionDTO.permission());
        return permissionRepo.save(updatedPermission);
    }

    @Override
    public void delete(Long id) {
        permissionRepo.deleteById(id);
    }
}
