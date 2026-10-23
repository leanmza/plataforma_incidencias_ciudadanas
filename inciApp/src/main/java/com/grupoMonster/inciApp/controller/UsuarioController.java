package com.grupoMonster.inciApp.controller;

import com.grupoMonster.inciApp.dto.request.PasswordRequestDTO;
import com.grupoMonster.inciApp.dto.request.UsuarioRequestDTO;
import com.grupoMonster.inciApp.dto.request.UsuarioUpdateRequestDTO;
import com.grupoMonster.inciApp.dto.response.UsuarioResponseDTO;
import com.grupoMonster.inciApp.service.imp.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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
    public ResponseEntity createUsuario(@RequestBody @Valid UsuarioRequestDTO userDTO){
        UsuarioResponseDTO newUser = userService.save(userDTO);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity updeteUsuario(@PathVariable String id, @RequestBody UsuarioUpdateRequestDTO userDTO){
        UsuarioResponseDTO updatedUser = userService.update(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    //No borra al usuario de la BD, le cambia enabled a false
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsuario(@PathVariable String id){
        UsuarioResponseDTO deletedUser = userService.delete(id);
        return ResponseEntity.ok(deletedUser);
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioResponseDTO> getMe (Authentication authentication){
        return ResponseEntity.ok(userService.findMe(authentication));
    }

    @PutMapping
    public ResponseEntity<UsuarioResponseDTO> updateMe(Authentication authentication,
                                                       @RequestBody UsuarioUpdateRequestDTO usuarioUpdateRequestDTO){
        return ResponseEntity.ok(userService.updateMe(authentication, usuarioUpdateRequestDTO));
    }

    @PatchMapping("/me/password")
    public ResponseEntity changeMyPassword(Authentication authentication,
                                           @RequestBody @Valid PasswordRequestDTO passwordRequestDTO){
    userService.changePassword(authentication, passwordRequestDTO);
    return ResponseEntity.ok("Contraseña actualizada correctamente");
    }
}
