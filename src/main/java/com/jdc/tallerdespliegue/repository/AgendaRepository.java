package com.jdc.tallerdespliegue.repository;

import com.jdc.tallerdespliegue.entity.Agenda;
import com.jdc.tallerdespliegue.entity.AgendaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, AgendaId> {
}
