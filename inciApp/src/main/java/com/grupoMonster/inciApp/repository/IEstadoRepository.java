package com.grupoMonster.inciApp.repository;

import com.grupoMonster.inciApp.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findByEstado(String estado);
}
