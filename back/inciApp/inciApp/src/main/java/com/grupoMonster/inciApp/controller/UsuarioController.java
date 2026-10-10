package com.grupoMonster.inciApp.controller;

import com.grupoMonster.inciApp.dto.request.UsuarioRequestDTO;
import com.grupoMonster.inciApp.dto.request.UsuarioUpdateRequestDTO;
import com.grupoMonster.inciApp.model.Usuario;
import com.grupoMonster.inciApp.service.imp.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {
    @Autowired
    private IUsuarioService userService;

    @GetMapping
    public ResponseEntity<List> getAllUsers(){
        List<Usuario> usuarios = userService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUsuarioById(@PathVariable String id){
        Optional<Usuario> user = userService.findById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity createUsuario(@RequestBody UsuarioRequestDTO userDTO){
        Usuario newUser = userService.save(userDTO);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity updeteUsuario(@PathVariable String id, @RequestBody UsuarioUpdateRequestDTO userDTO){
        Usuario updatedUser = userService.update(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsuario(@PathVariable String id){
        Usuario deletedUser = userService.delete(id);
        return ResponseEntity.ok(deletedUser);
    }
}
