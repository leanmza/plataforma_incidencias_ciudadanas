package com.grupoMonster.inciApp.controller;

import com.grupoMonster.inciApp.dto.request.LocalidadRequestDTO;
import com.grupoMonster.inciApp.dto.response.LocalidadResponseDTO;
import com.grupoMonster.inciApp.service.imp.ILocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localidades")
public class LocalidadController {
    @Autowired
    private ILocalidadService localidadService;

    @GetMapping
    public ResponseEntity<List> getAllLocalidades(){
        List<LocalidadResponseDTO> localidades = localidadService.findAll();
        return ResponseEntity.ok(localidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity getLocalidadById(@PathVariable Long id){
        LocalidadResponseDTO localidad = localidadService.findById(id);
        return ResponseEntity.ok(localidad);
    }

    @PostMapping
    public ResponseEntity createLocalidad(@RequestBody LocalidadRequestDTO localidad){
        LocalidadResponseDTO newLocalidad = localidadService.save(localidad);
        return ResponseEntity.ok(newLocalidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateLocalidad(@PathVariable Long id, @RequestBody LocalidadRequestDTO localidad){
        LocalidadResponseDTO updatedLocalidad = localidadService.update(id, localidad);
        return ResponseEntity.ok(updatedLocalidad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLocalidad(@PathVariable Long id){
        localidadService.delete(id);
        return ResponseEntity.ok("Localidad eliminada exitosamente");
    }
}
