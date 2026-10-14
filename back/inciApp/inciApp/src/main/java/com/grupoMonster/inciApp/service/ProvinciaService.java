package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.request.ProvinciaRequestDTO;
import com.grupoMonster.inciApp.dto.response.ProvinciaResponseDTO;
import com.grupoMonster.inciApp.mapper.IProvinciaMapper;
import com.grupoMonster.inciApp.model.Departamento;
import com.grupoMonster.inciApp.model.Provincia;
import com.grupoMonster.inciApp.repository.IDepartamentoRepository;
import com.grupoMonster.inciApp.repository.IProvinciaRepository;
import com.grupoMonster.inciApp.service.imp.IProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaService implements IProvinciaService {

    @Autowired
    private IProvinciaRepository provinciaRepo;

    @Autowired
    private IProvinciaMapper provinciaMapper;

    @Autowired
    private IDepartamentoRepository departamentoRepo;

    @Override
    public List<ProvinciaResponseDTO> findAll() {
        List<Provincia> provincias = provinciaRepo.findAll();
        return provinciaMapper.toListProvinciaResponse(provincias);
    }

    @Override
    public ProvinciaResponseDTO findById(Long id) {
        Provincia provincia = findProvincia(id);
        return provinciaMapper.toProvinciaResponseDTO(provincia);
    }

    @Override
    public ProvinciaResponseDTO save(ProvinciaRequestDTO provinciaRequestDTO) {
        Provincia newProvincia = provinciaMapper.toProvincia(provinciaRequestDTO);

        provinciaRepo.save(newProvincia);

        return provinciaMapper.toProvinciaResponseDTO(newProvincia);
    }

    @Override
    public ProvinciaResponseDTO update(Long id, ProvinciaRequestDTO provinciaRequestDTO) {
        Provincia updatedProvincia = findProvincia(id);

        List<Departamento> departamentos = departamentoRepo.findByProvinciaId(id);
        updatedProvincia.setNombre(provinciaRequestDTO.getNombre());

        updatedProvincia.setDepartamentos(departamentos);

        provinciaRepo.save(updatedProvincia);

        return provinciaMapper.toProvinciaResponseDTO(updatedProvincia);
    }

    @Override
    public void delete(Long id) {
        provinciaRepo.deleteById(id);
    }

    @Override
    public Provincia findProvincia(Long id) {
        return provinciaRepo.findById(id).orElseThrow(() -> new RuntimeException("Provincia no encontrada"));
    }
}
