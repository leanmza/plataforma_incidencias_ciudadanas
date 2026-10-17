package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.request.EstadoUpdateRequestDTO;
import com.grupoMonster.inciApp.dto.request.IncidenteRequestDTO;
import com.grupoMonster.inciApp.dto.request.PrioridadUpdateRequestDTO;
import com.grupoMonster.inciApp.dto.response.IncidenteResponseDTO;
import com.grupoMonster.inciApp.mapper.IIncidenteMapper;
import com.grupoMonster.inciApp.model.*;
import com.grupoMonster.inciApp.repository.IIncidenteRepository;
import com.grupoMonster.inciApp.service.imp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IncidenteService implements IIncidenteService {

    @Autowired
    private IIncidenteRepository incidenteRepo;

    @Autowired
    private ILocalidadService localidadService;

    @Autowired
    private IDepartamentoService departamentoService;

    @Autowired
    private IPrioridadService prioridadService;

    @Autowired
    private IEstadoService estadoService;

    @Autowired
    private ITipoService tipoService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IIncidenteMapper incidenteMapper;

    private static final String PRIORIDAD_DEFAULT = "MEDIA";
    private static final String ESTADO_DEFAULT = "PENDIENTE";


    @Override
    public List<IncidenteResponseDTO> findAll() {
        List<Incidente> incidentes = incidenteRepo.findAll();
        return incidenteMapper.toListIncidenteResponse(incidentes);
    }

    @Override
    public IncidenteResponseDTO findById(Long id) {
        Incidente incidente = findIncidente(id);
        return incidenteMapper.toIncidenteResponseDTO(incidente);
    }

    @Override
    public IncidenteResponseDTO save(IncidenteRequestDTO incidente) {
        Incidente newIncidente = incidenteMapper.toIncidente(incidente);

        Prioridad prioridad = findPrioridad(PRIORIDAD_DEFAULT);
        Estado estado = findEstado(ESTADO_DEFAULT);
        Usuario usuario = usuarioService.findByUsername(incidente.getUsername());
        Localidad localidad = findLocalidad(incidente.getIdLocalidad());
        Departamento departamento = findDepartamento(incidente.getIdDepartamento());
        Tipo tipo = findTipo(incidente.getIdTipo());

        newIncidente.setLocalidad(localidad);
        newIncidente.setDepartamento(departamento);
        newIncidente.setPrioridad(prioridad);
        newIncidente.setTipo(tipo);
        newIncidente.setEstado(estado);
        newIncidente.setUsuario(usuario);
        newIncidente.setFecha(LocalDate.now());

        incidenteRepo.save(newIncidente);
        return incidenteMapper.toIncidenteResponseDTO(newIncidente);
    }

    @Override
    public IncidenteResponseDTO update(Long id, IncidenteRequestDTO incidente) {
        Incidente updatedIncidente = findIncidente(id);

        if (incidente.getDescripcion() != null || !incidente.getDescripcion().isBlank()){
            updatedIncidente.setDescripcion(incidente.getDescripcion());
        }

        if (incidente.getDireccion() != null || !incidente.getDireccion().isBlank()){
            updatedIncidente.setDescripcion(incidente.getDireccion());
        }

        if(incidente.getIdLocalidad() != null){
            Localidad localidad = findLocalidad(incidente.getIdLocalidad());
            updatedIncidente.setLocalidad(localidad);
        }

        if (incidente.getIdDepartamento() != null){
            Departamento departamento = findDepartamento(incidente.getIdDepartamento());
            updatedIncidente.setDepartamento(departamento);
        }

        if (incidente.getIdTipo() != null){
            Tipo tipo = findTipo(incidente.getIdTipo());
            updatedIncidente.setTipo(tipo);
        }

        incidenteRepo.save(updatedIncidente);

        return incidenteMapper.toIncidenteResponseDTO(updatedIncidente);
    }

    @Override
    public void delete(Long id) {
        incidenteRepo.deleteById(id);

    }

    @Override
    public IncidenteResponseDTO updateEstado(Long id, EstadoUpdateRequestDTO estadoRequestDTO) {
        Incidente incidenteEstadoUpdated = findIncidente(id);

        Estado estado = estadoService.findEstado(estadoRequestDTO.getIdEstado());
        incidenteEstadoUpdated.setEstado(estado);
        incidenteRepo.save(incidenteEstadoUpdated);

        return incidenteMapper.toIncidenteResponseDTO(incidenteEstadoUpdated);
    }

    @Override
    public IncidenteResponseDTO updatePrioridad(Long id, PrioridadUpdateRequestDTO prioridadRequestDTO) {
        Incidente incidentePrioridadUpdated = findIncidente(id);

        Prioridad prioridad = prioridadService.findPrioridad(prioridadRequestDTO.getIdPrioridad());
        incidentePrioridadUpdated.setPrioridad(prioridad);
        incidenteRepo.save(incidentePrioridadUpdated);
        return incidenteMapper.toIncidenteResponseDTO(incidentePrioridadUpdated);
    }

    @Override
    public List<IncidenteResponseDTO> findIncidentesByUserId(String id) {
        List<Incidente> misIncidentes = incidenteRepo.findByUsuarioId(id);
        return incidenteMapper.toListIncidenteResponse(misIncidentes);
    }

    private Incidente findIncidente(Long id) {
        return incidenteRepo.findById(id).orElseThrow(() -> new RuntimeException("Incidente no encontrado"));
    }

    private Departamento findDepartamento(Long idDepartamento) {
        return departamentoService.findDepartamento(idDepartamento);
    }

    private Localidad findLocalidad(Long idLocalidad) {
        return localidadService.findLocalidad(idLocalidad);
    }

    private Estado findEstado(String estado) {
        return estadoService.findByEstado(estado);
    }

    private Tipo findTipo(Long idTipo) {
        return tipoService.findTipo(idTipo);
    }

    private Prioridad findPrioridad(String prioridad) {
        return prioridadService.findByPrioridad(prioridad);
    }

}
