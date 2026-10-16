package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.request.EstadoRequestDTO;
import com.grupoMonster.inciApp.dto.response.EstadoResponseDTO;
import com.grupoMonster.inciApp.mapper.IEstadoMapper;
import com.grupoMonster.inciApp.model.Estado;
import com.grupoMonster.inciApp.repository.IEstadoRepository;
import com.grupoMonster.inciApp.service.imp.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService implements IEstadoService {

    @Autowired
    private IEstadoRepository estadoRepo;

    @Autowired
    private IEstadoMapper estadoMapper;

    @Override
    public List<EstadoResponseDTO> findAll() {
        List<Estado> estados = estadoRepo.findAll();
        return estadoMapper.toListEstadoResponse(estados);
    }

    @Override
    public EstadoResponseDTO findById(Long id) {
        Estado estado = findEstado(id);
        return estadoMapper.toEstadoResponseDTO(estado);
    }

    @Override
    public EstadoResponseDTO save(EstadoRequestDTO estado) {
        Estado newEstado = estadoMapper.toEstado(estado);
        estadoRepo.save(newEstado);
        return estadoMapper.toEstadoResponseDTO(newEstado);
    }

    @Override
    public EstadoResponseDTO update(Long id, EstadoRequestDTO estado) {
        Estado updatedEstado = findEstado(id);

        updatedEstado.setEstado(estado.getEstado());

        estadoRepo.save(updatedEstado);
        return estadoMapper.toEstadoResponseDTO(updatedEstado);
    }

    @Override
    public void delete(Long id) {
        estadoRepo.deleteById(id);

    }

    @Override
    public Estado findEstado(Long id){
        return estadoRepo.findById(id).orElseThrow(()->new RuntimeException("Estado no encontrado"));
    }

    @Override
    public Estado findByEstado(String estado) {
        return estadoRepo.findByEstado(estado)
                .orElseThrow(()->new IllegalStateException("No existe estado por defecto: " + estado));
    }
}
