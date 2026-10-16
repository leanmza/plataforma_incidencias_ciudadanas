package com.grupoMonster.inciApp.repository;

import com.grupoMonster.inciApp.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartamentoRepository extends JpaRepository<Departamento, Long> {
    List<Departamento> findByProvinciaId(Long id);
}
