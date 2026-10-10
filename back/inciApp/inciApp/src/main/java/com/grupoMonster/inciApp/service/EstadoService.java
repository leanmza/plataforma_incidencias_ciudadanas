package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.repository.IEstadoRepository;
import com.grupoMonster.inciApp.service.imp.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService implements IEstadoService {

    @Autowired
    private IEstadoRepository estadoRepo;
}
