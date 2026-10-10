package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.repository.IProvinciaRepository;
import com.grupoMonster.inciApp.service.imp.IProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaService implements IProvinciaService {

    @Autowired
    private IProvinciaRepository provinciaRepo;
}
