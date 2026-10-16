package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.request.TipoRequestDTO;
import com.grupoMonster.inciApp.dto.response.TipoResponseDTO;
import com.grupoMonster.inciApp.mapper.ITipoMapper;
import com.grupoMonster.inciApp.model.Tipo;
import com.grupoMonster.inciApp.repository.ITipoRepository;
import com.grupoMonster.inciApp.service.imp.ITipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService implements ITipoService {

    @Autowired
    private ITipoRepository tipoRepo;

    @Autowired
    private ITipoMapper tipoMapper;

    @Override
    public List<TipoResponseDTO> findAll() {
        List<Tipo> tipos = tipoRepo.findAll();
        return tipoMapper.toListTipoResponse(tipos);
    }

    @Override
    public TipoResponseDTO findById(Long id) {
        Tipo tipo = findTipo(id);
        return tipoMapper.toTipoResponseDTO(tipo);
    }

    @Override
    public TipoResponseDTO save(TipoRequestDTO tipo) {
        Tipo newTipo = tipoMapper.toTipo(tipo);
        tipoRepo.save(newTipo);
        return tipoMapper.toTipoResponseDTO(newTipo);
    }

    @Override
    public TipoResponseDTO update(Long id, TipoRequestDTO tipo) {
        Tipo updatedTipo = findTipo(id);

        updatedTipo.setTipo(tipo.getTipo());
        tipoRepo.save(updatedTipo);
        return tipoMapper.toTipoResponseDTO(updatedTipo);
    }

    @Override
    public void delete(Long id) {
        tipoRepo.deleteById(id);
    }

    @Override
    public Tipo findTipo(Long id) {
        return tipoRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Tipo no encontrado"));
    }
}
