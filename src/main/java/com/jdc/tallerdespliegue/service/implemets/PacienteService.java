package com.jdc.tallerdespliegue.service.implemets;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.tallerdespliegue.entity.Paciente;
import com.jdc.tallerdespliegue.repository.PacienteRepository;
import com.jdc.tallerdespliegue.service.IPacienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteService implements IPacienteService {

    private final PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> buscarPorId(Integer id) {
        return pacienteRepository.findById(id);
    }

    @Override
    @Transactional
    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        pacienteRepository.deleteById(id);
    }
}
