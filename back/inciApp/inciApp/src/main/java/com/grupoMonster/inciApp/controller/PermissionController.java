package com.grupoMonster.inciApp.controller;

import com.grupoMonster.inciApp.dto.request.PermissionRequestDTO;
import com.grupoMonster.inciApp.model.Permission;
import com.grupoMonster.inciApp.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;

    @GetMapping
    public ResponseEntity<List> getAllPermissions(){
        List<Permission> permissions = permissionService.findAll();
        return ResponseEntity.ok(permissions);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPermissionById(@PathVariable Long id){
        Optional<Permission> permission = permissionService.findById(id);
        return permission.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity createPermission(@RequestBody PermissionRequestDTO permission){
        Permission newPermission = permissionService.save(permission);
        return ResponseEntity.ok(newPermission);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePermission(@PathVariable Long id, @RequestBody PermissionRequestDTO permission){
        Permission updatedPermission = permissionService.update(id,permission);
        return ResponseEntity.ok(updatedPermission);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePermission(@PathVariable Long id){
        permissionService.delete(id);
        return ResponseEntity.ok("Permission successfully deleted");
    }
}
