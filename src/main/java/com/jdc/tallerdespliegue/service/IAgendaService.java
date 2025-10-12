package com.jdc.tallerdespliegue.service;

import com.jdc.tallerdespliegue.entity.Agenda;
import java.util.List;

public interface IAgendaService {
    List<Agenda> listar();
    Agenda guardar(Agenda agenda);
    void eliminar(Integer idCita, Integer idPaciente);
}
