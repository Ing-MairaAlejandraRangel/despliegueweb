package com.jdc.tallerdespliegue.repository;

import com.jdc.tallerdespliegue.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {

    // Buscar citas entre dos fechas
    @Query("SELECT c FROM Cita c WHERE c.fechaCita BETWEEN :inicio AND :fin")
    List<Cita> findByRangoFechas(LocalDate inicio, LocalDate fin);
}
