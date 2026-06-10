package com.jdc.tallerdespliegue.rest;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.tallerdespliegue.entity.Cita;
import com.jdc.tallerdespliegue.service.implemets.CitaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class CitaRest {

    private final CitaService citaService;

    @GetMapping
    public List<Cita> listar() {
        return citaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> obtener(@PathVariable Integer id) {
        return citaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cita> guardar(@RequestBody Cita cita) {
        return ResponseEntity.status(HttpStatus.CREATED).body(citaService.guardar(cita));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> actualizar(@PathVariable Integer id, @RequestBody Cita cita) {
        return citaService.buscarPorId(id)
                .map(c -> {
                    cita.setIdcita(id);
                    return ResponseEntity.ok(citaService.guardar(cita));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        citaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // Consulta personalizada: rango de fechas
    @GetMapping("/rango")
    public List<Cita> buscarPorRangoFechas(@RequestParam String inicio, @RequestParam String fin) {
        LocalDate fechaInicio = LocalDate.parse(inicio);
        LocalDate fechaFin = LocalDate.parse(fin);
        return citaService.buscarPorRangoFechas(fechaInicio, fechaFin);
    }
}
