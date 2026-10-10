package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.request.LocalidadRequestDTO;
import com.grupoMonster.inciApp.dto.response.LocalidadResponseDTO;
import com.grupoMonster.inciApp.mapper.ILocalidadMapper;
import com.grupoMonster.inciApp.model.Localidad;
import com.grupoMonster.inciApp.repository.ILocalidadRepository;
import com.grupoMonster.inciApp.service.imp.ILocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadService implements ILocalidadService {
    @Autowired
    private ILocalidadRepository localidadRepo;
    @Autowired
    private ILocalidadMapper localidadMapper;

    @Override
    public List<LocalidadResponseDTO> findAll() {
        List<Localidad> localidades = localidadRepo.findAll();
        return localidadMapper.toListLocalidadResponse(localidades);
    }

    @Override
    public LocalidadResponseDTO findById(Long id) {
        Localidad localidad = localidadRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Localidad no encontrada"));
        return localidadMapper.toLocalidadResponse(localidad);
    }

    @Override
    public LocalidadResponseDTO save(LocalidadRequestDTO localidad) {
        Localidad newLocalidad = localidadRepo.save(localidadMapper.toLocalidad(localidad));
        return localidadMapper.toLocalidadResponse(newLocalidad);
    }

    @Override
    public LocalidadResponseDTO update(Long id, LocalidadRequestDTO localidad) {
        Localidad updatedLocalidad = localidadRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Localidad no encontrada"));

        updatedLocalidad = localidadMapper.toLocalidad(localidad);
        localidadRepo.save(updatedLocalidad);
        return localidadMapper.toLocalidadResponse(updatedLocalidad);
    }

    @Override
    public void delete(Long id) {
        localidadRepo.deleteById(id);

    }
}
