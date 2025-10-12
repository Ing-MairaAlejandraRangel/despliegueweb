package com.jdc.tallerdespliegue.rest;

import com.jdc.tallerdespliegue.entity.Medico;
import com.jdc.tallerdespliegue.service.implement.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@RequiredArgsConstructor
public class MedicoRest {

    private final MedicoService medicoService;

    @GetMapping
    public List<Medico> listar() {
        return medicoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> obtener(@PathVariable Integer id) {
        return medicoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Medico> guardar(@RequestBody Medico medico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.guardar(medico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> actualizar(@PathVariable Integer id, @RequestBody Medico medico) {
        return medicoService.buscarPorId(id)
                .map(m -> {
                    medico.setIdmedico(id);
                    return ResponseEntity.ok(medicoService.guardar(medico));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        medicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
