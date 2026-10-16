package com.grupoMonster.inciApp.controller;


import com.grupoMonster.inciApp.dto.request.EstadoUpdateRequestDTO;
import com.grupoMonster.inciApp.dto.request.IncidenteRequestDTO;
import com.grupoMonster.inciApp.dto.request.PrioridadUpdateRequestDTO;
import com.grupoMonster.inciApp.dto.response.IncidenteResponseDTO;
import com.grupoMonster.inciApp.service.imp.IIncidenteService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidentes")
public class IncidenteController {

    @Autowired
    private IIncidenteService incidenteService;

    @GetMapping
    public ResponseEntity<List> incidentes() {
        List<IncidenteResponseDTO> incidentes = incidenteService.findAll();
        return ResponseEntity.ok(incidentes);
    }

    @GetMapping("/{id}")
    public ResponseEntity getIncidenteById(@PathVariable Long id) {
        IncidenteResponseDTO incidente = incidenteService.findById(id);
        return ResponseEntity.ok(incidente);
    }

    @PostMapping
    public ResponseEntity createIncidente(@RequestBody @Valid  IncidenteRequestDTO incidente) {
        IncidenteResponseDTO newIncidente = incidenteService.save(incidente);
        return ResponseEntity.ok(newIncidente);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateIncidente(@PathVariable Long id, @RequestBody IncidenteRequestDTO incidente) {
        IncidenteResponseDTO updatedIncidente = incidenteService.update(id,incidente);
        return ResponseEntity.ok(updatedIncidente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteIncidente(@PathVariable Long id) {
        incidenteService.delete(id);
        return ResponseEntity.ok("Incidente eliminada exitosamente");
    }

    @PatchMapping("/estado/{id}")
    public ResponseEntity changeEstado(@PathVariable Long id, @RequestBody EstadoUpdateRequestDTO estadoRequestDTO){
        IncidenteResponseDTO incidenteEstadoUpdated = incidenteService.updateEstado(id, estadoRequestDTO);
        return ResponseEntity.ok(incidenteEstadoUpdated);
    }

    @PatchMapping("/prioridad/{id}")
    public ResponseEntity changePrioridad(@PathVariable Long id, @RequestBody PrioridadUpdateRequestDTO prioridadRequestDTO){
        IncidenteResponseDTO incidentePrioridadUpdated = incidenteService.updatePrioridad(id, prioridadRequestDTO);
        return ResponseEntity.ok(incidentePrioridadUpdated);
    }
}
