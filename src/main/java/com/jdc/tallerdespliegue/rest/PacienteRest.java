package com.jdc.tallerdespliegue.rest;

import com.jdc.tallerdespliegue.entity.Paciente;
import com.jdc.tallerdespliegue.service.implement.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
