package com.grupoMonster.inciApp.controller;

import com.grupoMonster.inciApp.dto.request.UsuarioRequestDTO;
import com.grupoMonster.inciApp.dto.request.UsuarioUpdateRequestDTO;
import com.grupoMonster.inciApp.dto.response.UsuarioResponseDTO;
import com.grupoMonster.inciApp.service.imp.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UsuarioController {
    @Autowired
    private IUsuarioService userService;

    @GetMapping
    public ResponseEntity<List> getAllUsers(){
        List<UsuarioResponseDTO> usuarios = userService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUsuarioById(@PathVariable String id){
        UsuarioResponseDTO usuario = userService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity createUsuario(@RequestBody UsuarioRequestDTO userDTO){
        UsuarioResponseDTO newUser = userService.save(userDTO);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity updeteUsuario(@PathVariable String id, @RequestBody UsuarioUpdateRequestDTO userDTO){
        UsuarioResponseDTO updatedUser = userService.update(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsuario(@PathVariable String id){
        UsuarioResponseDTO deletedUser = userService.delete(id);
        return ResponseEntity.ok(deletedUser);
    }
}
