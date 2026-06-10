package com.jdc.tallerdespliegue.service.implemets;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.tallerdespliegue.entity.Medico;
import com.jdc.tallerdespliegue.repository.MedicoRepository;
import com.jdc.tallerdespliegue.service.IMedicoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicoService implements IMedicoService {

    private final MedicoRepository medicoRepository;

    @Override
    public List<Medico> listar() {
        return medicoRepository.findAll();
    }

    @Override
    public Optional<Medico> buscarPorId(Integer id) {
        return medicoRepository.findById(id);
    }

    @Override
    @Transactional
    public Medico guardar(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        medicoRepository.deleteById(id);
    }
}
