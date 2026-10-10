package com.grupoMonster.inciApp.repository;

import com.grupoMonster.inciApp.model.Prioridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrioridadRepositoy extends JpaRepository<Prioridad,Long> {
}
