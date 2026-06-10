package com.jdc.tallerdespliegue.service.implemets;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.tallerdespliegue.entity.Agenda;
import com.jdc.tallerdespliegue.entity.AgendaId;
import com.jdc.tallerdespliegue.repository.AgendaRepository;
import com.jdc.tallerdespliegue.service.IAgendaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgendaService implements IAgendaService {

    private final AgendaRepository agendaRepository;

    @Override
    public List<Agenda> listar() {
        return agendaRepository.findAll();
    }

    @Override
    @Transactional
    public Agenda guardar(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    @Override
    @Transactional
    public void eliminar(Integer idCita, Integer idPaciente) {
        AgendaId id = new AgendaId(idCita, idPaciente);
        agendaRepository.deleteById(id);
    }
}
