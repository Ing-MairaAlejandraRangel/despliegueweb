package com.jdc.tallerdespliegue.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.tallerdespliegue.entity.Paciente;
import com.jdc.tallerdespliegue.service.implemets.PacienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteRest {

    private final PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listar() {
        return pacienteService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtener(@PathVariable Integer id) {
        return pacienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.guardar(paciente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Integer id, @RequestBody Paciente paciente) {
        return pacienteService.buscarPorId(id)
                .map(p -> {
                    paciente.setIdpaciente(id);
                    return ResponseEntity.ok(pacienteService.guardar(paciente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        pacienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}