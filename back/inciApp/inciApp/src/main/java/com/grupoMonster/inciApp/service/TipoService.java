package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.repository.ITipoRepository;
import com.grupoMonster.inciApp.service.imp.ITipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoService implements ITipoService {

    @Autowired
    private ITipoRepository tipoRepo;
}
