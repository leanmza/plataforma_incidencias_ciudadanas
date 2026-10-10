package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.repository.IDepartamentoRepository;
import com.grupoMonster.inciApp.service.imp.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService implements IDepartamentoService {

    @Autowired
    private IDepartamentoRepository departamentoRepo;
}
