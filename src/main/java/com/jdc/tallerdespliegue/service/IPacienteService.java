package com.jdc.tallerdespliegue.service;

import com.jdc.tallerdespliegue.entity.Paciente;
import java.util.List;
import java.util.Optional;

public interface IPacienteService {
    List<Paciente> listar();
    Optional<Paciente> buscarPorId(Integer id);
    Paciente guardar(Paciente paciente);
    void eliminar(Integer id);
}
