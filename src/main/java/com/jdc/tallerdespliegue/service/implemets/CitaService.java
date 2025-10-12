package com.jdc.tallerdespliegue.service.implement;

import com.jdc.tallerdespliegue.entity.Cita;
import com.jdc.tallerdespliegue.repository.CitaRepository;
import com.jdc.tallerdespliegue.service.ICitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CitaService implements ICitaService {

    private final CitaRepository citaRepository;

    @Override
    public List<Cita> listar() {
        return citaRepository.findAll();
    }

    @Override
    public Optional<Cita> buscarPorId(Integer id) {
        return citaRepository.findById(id);
    }

    @Override
    @Transactional
    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        citaRepository.deleteById(id);
    }

    @Override
    public List<Cita> buscarPorRangoFechas(LocalDate inicio, LocalDate fin) {
        return citaRepository.findByRangoFechas(inicio, fin);
    }
}
