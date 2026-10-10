package com.grupoMonster.inciApp.repository;

import com.grupoMonster.inciApp.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado, Long> {
}
