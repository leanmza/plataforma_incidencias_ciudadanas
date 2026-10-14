package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.request.PrioridadRequestDTO;
import com.grupoMonster.inciApp.dto.response.PrioridadResponseDTO;
import com.grupoMonster.inciApp.mapper.IPrioridadMapper;
import com.grupoMonster.inciApp.model.Prioridad;
import com.grupoMonster.inciApp.repository.IPrioridadRepositoy;
import com.grupoMonster.inciApp.service.imp.IPrioridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrioridadService implements IPrioridadService {

    @Autowired
    private IPrioridadRepositoy prioridadRepo;

    @Autowired
    private IPrioridadMapper prioridadMapper;

    @Override
    public List<PrioridadResponseDTO> findAll() {
        List<Prioridad> prioridades = prioridadRepo.findAll();
        return prioridadMapper.toListPrioridadResponse(prioridades);
    }

    @Override
    public PrioridadResponseDTO findById(Long id) {
        Prioridad prioridad = findPrioridad(id);
        return prioridadMapper.toPrioridadResponseDTO(prioridad);
    }

    @Override
    public PrioridadResponseDTO save(PrioridadRequestDTO prioridad) {
        Prioridad newPrioridad = prioridadMapper.toPrioridad(prioridad);
        prioridadRepo.save(newPrioridad);
        return prioridadMapper.toPrioridadResponseDTO(newPrioridad);
    }

    @Override
    public PrioridadResponseDTO update(Long id, PrioridadRequestDTO prioridad) {
        Prioridad updatedPrioridad = findPrioridad(id);
        updatedPrioridad.setPrioridad(prioridad.prioridad());
        prioridadRepo.save(updatedPrioridad);
        return prioridadMapper.toPrioridadResponseDTO(updatedPrioridad);
    }

    @Override
    public void delete(Long id) {
        prioridadRepo.deleteById(id);
    }

    @Override
    public Prioridad findByPrioridad(String prioridad) {
        return prioridadRepo.findByPrioridad(prioridad)
                .orElseThrow(()->new IllegalStateException("No existe prioridad por defecto: " + prioridad));

    }

    @Override
    public Prioridad findPrioridad(Long id) {
        return prioridadRepo.findById(id).orElseThrow(() -> new RuntimeException("Prioridad no encontrada"));
    }
}
