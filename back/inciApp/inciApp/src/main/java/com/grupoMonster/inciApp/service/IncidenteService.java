package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.repository.IIncidenteRepository;
import com.grupoMonster.inciApp.service.imp.IIncidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidenteService implements IIncidenteService {

    @Autowired
    private IIncidenteRepository incidenteRepo;
}
