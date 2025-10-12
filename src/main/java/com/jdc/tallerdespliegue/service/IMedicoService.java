package com.jdc.tallerdespliegue.service;

import com.jdc.tallerdespliegue.entity.Medico;
import java.util.List;
import java.util.Optional;

public interface IMedicoService {
    List<Medico> listar();
    Optional<Medico> buscarPorId(Integer id);
    Medico guardar(Medico medico);
    void eliminar(Integer id);
}
