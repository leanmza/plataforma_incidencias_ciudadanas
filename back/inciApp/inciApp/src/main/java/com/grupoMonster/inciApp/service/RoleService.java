package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.RoleRequestDTO;
import com.grupoMonster.inciApp.model.Permission;
import com.grupoMonster.inciApp.model.Role;
import com.grupoMonster.inciApp.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepo;

    @Autowired
    private IPermissionService permissionService;

    @Override
    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepo.findById(id);
    }

    @Override
    public Role save(RoleRequestDTO roleDTO) {

        Role role = new Role();
        role.setRole(roleDTO.getRole());

        Set<Permission> permissionList = new HashSet<>();
        Permission readPermission;

        //Recuperar el Permission/s por su ID
        for (Long permissionId : roleDTO.getPermissionsList()) {
            readPermission = permissionService.findById(permissionId).orElse(null);
            if (readPermission != null) {
                permissionList.add(readPermission);
            }
        }
        role.setPermissionsList(permissionList);

        return roleRepo.save(role);
    }

    @Override
    public Role update(Long id, RoleRequestDTO roleDTO) {
        Role updatedRole = findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Set<Permission> permissionList = new HashSet<>();
        Permission readPermission;

        //Recuperar el Permission/s por su ID
        for (Long permissionId : roleDTO.getPermissionsList()) {
            readPermission = permissionService.findById(permissionId).orElse(null);
            if (readPermission != null) {
                permissionList.add(readPermission);
            }
        }


        updatedRole.setRole(roleDTO.getRole());
        updatedRole.setPermissionsList(permissionList);


        return roleRepo.save(updatedRole);
    }

    @Override
    public void delete(Long id) {
        roleRepo.deleteById(id);
    }
}
