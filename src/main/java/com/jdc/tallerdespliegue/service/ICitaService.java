package com.jdc.tallerdespliegue.service;

import com.jdc.tallerdespliegue.entity.Cita;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ICitaService {
    List<Cita> listar();
    Optional<Cita> buscarPorId(Integer id);
    Cita guardar(Cita cita);
    void eliminar(Integer id);
    List<Cita> buscarPorRangoFechas(LocalDate inicio, LocalDate fin);
}
