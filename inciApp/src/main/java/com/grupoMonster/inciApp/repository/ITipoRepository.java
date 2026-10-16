package com.grupoMonster.inciApp.repository;

import com.grupoMonster.inciApp.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoRepository extends JpaRepository<Tipo, Long> {

}
