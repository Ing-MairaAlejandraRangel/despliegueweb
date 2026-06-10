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

import com.jdc.tallerdespliegue.entity.Medico;
import com.jdc.tallerdespliegue.service.implemets.MedicoService;

import lombok.RequiredArgsConstructor;

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
