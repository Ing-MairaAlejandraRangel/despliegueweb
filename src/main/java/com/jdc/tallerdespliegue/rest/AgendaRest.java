package com.jdc.tallerdespliegue.rest;

import com.jdc.tallerdespliegue.entity.Agenda;
import com.jdc.tallerdespliegue.service.implemets.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendas")
@RequiredArgsConstructor
public class AgendaRest {

    private final AgendaService agendaService;

    @GetMapping
    public List<Agenda> listar() {
        return agendaService.listar();
    }

    @PostMapping
    public ResponseEntity<Agenda> guardar(@RequestBody Agenda agenda) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaService.guardar(agenda));
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminar(@RequestParam Integer idCita, @RequestParam Integer idPaciente) {
        agendaService.eliminar(idCita, idPaciente);
        return ResponseEntity.noContent().build();
    }
}