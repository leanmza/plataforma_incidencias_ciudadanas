package com.grupoMonster.inciApp.controller;

import com.grupoMonster.inciApp.dto.request.TipoRequestDTO;
import com.grupoMonster.inciApp.dto.response.TipoResponseDTO;
import com.grupoMonster.inciApp.service.imp.ITipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos")
public class TipoController {

    @Autowired
    private ITipoService tipoService;

    @GetMapping
    public ResponseEntity<List> getAllTipos(){
        List<TipoResponseDTO> tipos = tipoService.findAll();
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTipoById(@PathVariable Long id){
        TipoResponseDTO tipo = tipoService.findById(id);
        return ResponseEntity.ok(tipo);
    }

    @PostMapping
    public ResponseEntity createTipo(@RequestBody TipoRequestDTO tipo){
        TipoResponseDTO newTipo = tipoService.save(tipo);
        return ResponseEntity.ok(newTipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTipo(@PathVariable Long id, @RequestBody TipoRequestDTO tipo){
        TipoResponseDTO updatedTipo = tipoService.update(id,tipo);
        return ResponseEntity.ok(updatedTipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTipo(@PathVariable Long id){
        tipoService.delete(id);
        return ResponseEntity.ok("Tipo eliminado exitosamente");
    }
}
