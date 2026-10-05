package com.grupoMonster.inciApp.repository;

import com.grupoMonster.inciApp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findUserEntityByUsername(String username);
}
