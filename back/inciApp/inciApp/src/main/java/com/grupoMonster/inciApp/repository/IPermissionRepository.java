package com.grupoMonster.inciApp.repository;

import com.grupoMonster.inciApp.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission, Long> {
}
