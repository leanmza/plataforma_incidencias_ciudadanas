package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.request.DepartamentoRequestDTO;
import com.grupoMonster.inciApp.dto.response.DepartamentoResponseDTO;
import com.grupoMonster.inciApp.mapper.IDepartamentoMapper;
import com.grupoMonster.inciApp.model.Departamento;
import com.grupoMonster.inciApp.model.Provincia;
import com.grupoMonster.inciApp.repository.IDepartamentoRepository;
import com.grupoMonster.inciApp.repository.IProvinciaRepository;
import com.grupoMonster.inciApp.service.imp.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService implements IDepartamentoService {

    @Autowired
    private IDepartamentoRepository departamentoRepo;

    @Autowired
    private IDepartamentoMapper departamentoMapper;

    @Autowired
    private IProvinciaRepository provinciaRepo;

    @Override
    public List<DepartamentoResponseDTO> findAll() {
        List<Departamento> departamentos = departamentoRepo.findAll();
        return departamentoMapper.toListDepartamentoResponse(departamentos);
    }

    @Override
    public DepartamentoResponseDTO findById(Long id) {
        Departamento departamento = findDepartamento(id);
        return departamentoMapper.toDepartamentoResponse(departamento);
    }

    @Override
    public DepartamentoResponseDTO save(DepartamentoRequestDTO departamentoRequestDTO) {
        Departamento newDepartamento = new Departamento();

        Provincia provincia = provinciaRepo.findById(departamentoRequestDTO.getProvinciaId())
                .orElseThrow(() -> new RuntimeException("Provincia no encontrada"));

        newDepartamento.setNombre(departamentoRequestDTO.getNombre());
        newDepartamento.setProvincia(provincia);

        departamentoRepo.save(newDepartamento);
        return departamentoMapper.toDepartamentoResponse(newDepartamento);
    }

    @Override
    public DepartamentoResponseDTO update(Long id, DepartamentoRequestDTO departamentoRequestDTO) {

        Departamento updatedDepartamento = findDepartamento(id);

        Provincia provincia = provinciaRepo.findById(departamentoRequestDTO.getProvinciaId())
                .orElseThrow(() -> new RuntimeException("Provincia no encontrada"));

        updatedDepartamento.setNombre(departamentoRequestDTO.getNombre());
        updatedDepartamento.setProvincia(provincia);

        departamentoRepo.save(updatedDepartamento);
        return departamentoMapper.toDepartamentoResponse(updatedDepartamento);
    }

    @Override
    public void delete(Long id) {
        departamentoRepo.deleteById(id);
    }

    @Override
    public Departamento findDepartamento(Long id) {
        return departamentoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
    }
}
