package com.jdc.tallerdespliegue.repository;

import com.jdc.tallerdespliegue.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
