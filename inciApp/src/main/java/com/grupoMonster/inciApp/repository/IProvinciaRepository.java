package com.grupoMonster.inciApp.repository;

import com.grupoMonster.inciApp.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinciaRepository extends JpaRepository<Provincia,Long> {
}
