package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.UsuarioRequestDTO;
import com.grupoMonster.inciApp.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<Usuario> findAll();

    Optional<Usuario> findById(String id);

    Usuario save(UsuarioRequestDTO userDTO);

    Usuario update(String id, UsuarioRequestDTO userDTO);

    Usuario delete(String id);

    String encriptPassword(String password);
}
