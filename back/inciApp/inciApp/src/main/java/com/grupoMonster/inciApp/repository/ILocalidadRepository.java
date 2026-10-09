package com.grupoMonster.inciApp.repository;

import com.grupoMonster.inciApp.model.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocalidadRepository extends JpaRepository<Localidad, Long> {
    //todo falta hacer repositorio, IService, service, dto's, controller de localidad, departamento, provincia, estado, tipo, incidente y prioridad
}
