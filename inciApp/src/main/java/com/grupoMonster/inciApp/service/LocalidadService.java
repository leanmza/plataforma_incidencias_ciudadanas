package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.request.LocalidadRequestDTO;
import com.grupoMonster.inciApp.dto.response.LocalidadResponseDTO;
import com.grupoMonster.inciApp.mapper.IDepartamentoMapper;
import com.grupoMonster.inciApp.mapper.ILocalidadMapper;
import com.grupoMonster.inciApp.model.Departamento;
import com.grupoMonster.inciApp.model.Localidad;
import com.grupoMonster.inciApp.repository.IDepartamentoRepository;
import com.grupoMonster.inciApp.repository.ILocalidadRepository;
import com.grupoMonster.inciApp.service.imp.ILocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadService implements ILocalidadService {
    @Autowired
    private ILocalidadRepository localidadRepo;
    @Autowired
    private ILocalidadMapper localidadMapper;

    @Autowired
    private IDepartamentoMapper departamentoMapper;

    @Autowired
    private IDepartamentoRepository departamentoRepo;

    @Override
    public List<LocalidadResponseDTO> findAll() {
        List<Localidad> localidades = localidadRepo.findAll();
        return localidadMapper.toListLocalidadResponse(localidades);
    }

    @Override
    public LocalidadResponseDTO findById(Long id) {
        Localidad localidad = findLocalidad(id);
        return localidadMapper.toLocalidadResponse(localidad);
    }

    @Override
    public LocalidadResponseDTO save(LocalidadRequestDTO localidad) {

        Departamento departamento = departamentoRepo.findById(localidad.getDepartamentoId())
                .orElseThrow(()->new RuntimeException("Departamento no encontrado"));

        Localidad newLocalidad = localidadMapper.toLocalidad(localidad);
        newLocalidad.setNombre(localidad.getNombre());
        newLocalidad.setDepartamento(departamento);

        localidadRepo.save(newLocalidad);
        return localidadMapper.toLocalidadResponse(newLocalidad);
    }

    @Override
    public LocalidadResponseDTO update(Long id, LocalidadRequestDTO localidad) {
        Localidad updatedLocalidad = findLocalidad(id);

        Departamento departamento = departamentoRepo.findById(localidad.getDepartamentoId())
                        .orElseThrow(()->new RuntimeException("Departamento no encontrado"));

        updatedLocalidad.setNombre(localidad.getNombre());
        updatedLocalidad.setDepartamento(departamento);

        localidadRepo.save(updatedLocalidad);
        return localidadMapper.toLocalidadResponse(updatedLocalidad);
    }

    @Override
    public void delete(Long id) {
        localidadRepo.deleteById(id);
    }

    @Override
    public Localidad findLocalidad(Long id) {
        return localidadRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Localidad no encontrada"));
    }
}
