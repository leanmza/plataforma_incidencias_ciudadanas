package com.grupoMonster.inciApp.controller;

import com.grupoMonster.inciApp.dto.request.RoleRequestDTO;
import com.grupoMonster.inciApp.model.Role;
import com.grupoMonster.inciApp.service.imp.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @GetMapping
    public ResponseEntity<List> getAllRoles() {
        List<Role> roles = roleService.findAll();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity getRoleById(@PathVariable Long id) {
        Optional<Role> role = roleService.findById(id);
        return role.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity createRole(@RequestBody RoleRequestDTO roleDTO) {
        Role newRole = roleService.save(roleDTO);
        return ResponseEntity.ok(newRole);

    }

    @PutMapping("/{id}")
    public ResponseEntity updateRole(@PathVariable Long id, @RequestBody RoleRequestDTO roleDTO) {
        Role updatedRole = roleService.update(id, roleDTO);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRole(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity.ok("Role successfully deleted");
    }
}
