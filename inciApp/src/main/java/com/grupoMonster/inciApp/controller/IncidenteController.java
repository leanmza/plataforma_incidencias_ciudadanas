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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @GetMapping("/user/{id}")
    public ResponseEntity<List> getIncidentesByUserId(@PathVariable String id){
        List<IncidenteResponseDTO> misIncidentes = incidenteService.findIncidentesByUserId(id);
        return ResponseEntity.ok(misIncidentes);
    }

    @PostMapping
    public ResponseEntity createIncidente(@RequestPart(value="incidente") @Valid  IncidenteRequestDTO incidente,
                                          @RequestPart(value="images", required = true) List<MultipartFile> images) throws IOException {
        IncidenteResponseDTO newIncidente = incidenteService.save(incidente, images);
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
