package com.grupoMonster.inciApp.controller;

import com.grupoMonster.inciApp.dto.request.EstadoRequestDTO;
import com.grupoMonster.inciApp.dto.response.EstadoResponseDTO;
import com.grupoMonster.inciApp.service.imp.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private IEstadoService estadoService;

    @GetMapping
    public ResponseEntity<List> getAllEstados(){
        List<EstadoResponseDTO> estados = estadoService.findAll();
        return ResponseEntity.ok(estados);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEstadoById(@PathVariable Long id){
        EstadoResponseDTO estado = estadoService.findById(id);
        return ResponseEntity.ok(estado);
    }

    @PostMapping
    public ResponseEntity createEstado (@RequestBody EstadoRequestDTO estado){
        EstadoResponseDTO newEstado = estadoService.save(estado);
        return ResponseEntity.ok(newEstado);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateEstado (@PathVariable Long id, @RequestBody EstadoRequestDTO estado){
        EstadoResponseDTO updatedEstado = estadoService.update(id,estado);
        return ResponseEntity.ok(updatedEstado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEstado(@PathVariable Long id){
        estadoService.delete(id);
        return ResponseEntity.ok("Estado eliminado exitosamente");
    }

}
