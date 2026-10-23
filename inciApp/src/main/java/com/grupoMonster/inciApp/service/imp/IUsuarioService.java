package com.grupoMonster.inciApp.service.imp;

import com.grupoMonster.inciApp.dto.request.PasswordRequestDTO;
import com.grupoMonster.inciApp.dto.request.UsuarioRequestDTO;
import com.grupoMonster.inciApp.dto.request.UsuarioUpdateRequestDTO;
import com.grupoMonster.inciApp.dto.response.UsuarioResponseDTO;
import com.grupoMonster.inciApp.model.Usuario;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioResponseDTO> findAll();

    UsuarioResponseDTO findById(String id);

    UsuarioResponseDTO save(UsuarioRequestDTO userDTO);

    UsuarioResponseDTO update(String id, UsuarioUpdateRequestDTO userDTO);

    UsuarioResponseDTO delete(String id);

    String encriptPassword(String password);

    Usuario findByUsername(String username);

    UsuarioResponseDTO findMe(Authentication authentication);

    UsuarioResponseDTO updateMe(Authentication authentication, UsuarioUpdateRequestDTO usuarioUpdateRequestDTO);

    void changePassword(Authentication authentication, @Valid PasswordRequestDTO passwordRequestDTO);
}
