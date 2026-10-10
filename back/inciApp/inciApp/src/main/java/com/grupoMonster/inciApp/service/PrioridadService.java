package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.repository.IPrioridadRepositoy;
import com.grupoMonster.inciApp.service.imp.IPrioridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrioridadService implements IPrioridadService {

    @Autowired
    private IPrioridadRepositoy prioridadRepo;
}
