package com.grupoMonster.inciApp.repository;

import com.grupoMonster.inciApp.model.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIncidenteRepository extends JpaRepository<Incidente,Long> {
    List<Incidente> findByUsuarioId(String id);
}
