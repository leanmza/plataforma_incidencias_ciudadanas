package com.grupoMonster.inciApp.controller;

import com.grupoMonster.inciApp.dto.request.ProvinciaRequestDTO;
import com.grupoMonster.inciApp.dto.response.ProvinciaResponseDTO;
import com.grupoMonster.inciApp.service.imp.IProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {

    @Autowired
    private IProvinciaService provinciaService;

    @GetMapping
    public ResponseEntity<List> getAllProvincias(){
        List<ProvinciaResponseDTO> provincias = provinciaService.findAll();
        return ResponseEntity.ok(provincias);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProvinciaById(@PathVariable Long id){
        ProvinciaResponseDTO provincia = provinciaService.findById(id);
        return ResponseEntity.ok(provincia);
    }

    @PostMapping
    public ResponseEntity createProvincia(@RequestBody ProvinciaRequestDTO provinciaRequestDTO){
        ProvinciaResponseDTO newProvincia = provinciaService.save(provinciaRequestDTO);
        return ResponseEntity.ok(newProvincia);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProvincia(@PathVariable Long id, @RequestBody ProvinciaRequestDTO provinciaRequestDTO){
        ProvinciaResponseDTO updatedProvincia = provinciaService.update(id, provinciaRequestDTO);
        return ResponseEntity.ok(updatedProvincia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProvincia(@PathVariable Long id){
        provinciaService.delete(id);
        return ResponseEntity.ok("Provincia eliminada exitosamente");
    }
}
