package com.grupoMonster.inciApp.controller;

import com.grupoMonster.inciApp.dto.request.DepartamentoRequestDTO;
import com.grupoMonster.inciApp.dto.response.DepartamentoResponseDTO;
import com.grupoMonster.inciApp.service.imp.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
    private IDepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List> getAllDepartamentos(){
        List<DepartamentoResponseDTO>  departamentos = departamentoService.findAll();
        return ResponseEntity.ok(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDepartamentoById(@PathVariable Long id){
        DepartamentoResponseDTO departamento = departamentoService.findById(id);
        return ResponseEntity.ok(departamento);
    }

    @PostMapping
    public ResponseEntity createDepartamento(@RequestBody DepartamentoRequestDTO departamentoRequestDTO){
        DepartamentoResponseDTO newDepartamento = departamentoService.save(departamentoRequestDTO);
        return ResponseEntity.ok(newDepartamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateDepartamento(@PathVariable Long id,
                                             @RequestBody DepartamentoRequestDTO departamentoRequestDTO){
        DepartamentoResponseDTO updatedDepartamento = departamentoService.update(id,departamentoRequestDTO);
        return ResponseEntity.ok(updatedDepartamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDepartamento(@PathVariable Long id){
        departamentoService.delete(id);
        return ResponseEntity.ok("Departamento eliminado exitosamente");
    }

}
