package com.grupoMonster.inciApp.controller;

import com.grupoMonster.inciApp.dto.request.PrioridadRequestDTO;
import com.grupoMonster.inciApp.dto.response.PrioridadResponseDTO;
import com.grupoMonster.inciApp.service.imp.IPrioridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prioridades")
public class PrioridadController {

    @Autowired
    private IPrioridadService prioridadService;

    @GetMapping
    public ResponseEntity<List> getPrioridades(){
        List<PrioridadResponseDTO> prioridades = prioridadService.findAll();
        return ResponseEntity.ok(prioridades);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPrioridadById(@PathVariable Long id){
        PrioridadResponseDTO prioridad = prioridadService.findById(id);
        return ResponseEntity.ok(prioridad);
    }

    @PostMapping
    public ResponseEntity createPrioridad(@RequestBody PrioridadRequestDTO prioridad){
        PrioridadResponseDTO newPrioridad = prioridadService.save(prioridad);
        return ResponseEntity.ok(newPrioridad);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePrioridad(@PathVariable Long id, @RequestBody PrioridadRequestDTO prioridad){
        PrioridadResponseDTO updatedPrioridad = prioridadService.update(id,prioridad);
        return ResponseEntity.ok(updatedPrioridad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePrioridad(@PathVariable Long id){
        prioridadService.delete(id);
        return ResponseEntity.ok("Prioridad eliminada exitosamente");
    }
}
