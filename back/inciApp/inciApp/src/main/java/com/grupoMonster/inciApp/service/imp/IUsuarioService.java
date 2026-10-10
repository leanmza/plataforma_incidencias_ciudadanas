package com.grupoMonster.inciApp.service.imp;

import com.grupoMonster.inciApp.dto.request.UsuarioRequestDTO;
import com.grupoMonster.inciApp.dto.request.UsuarioUpdateRequestDTO;
import com.grupoMonster.inciApp.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<Usuario> findAll();

    Optional<Usuario> findById(String id);

    Usuario save(UsuarioRequestDTO userDTO);

    Usuario update(String id, UsuarioUpdateRequestDTO userDTO);

    Usuario delete(String id);

    String encriptPassword(String password);
}
