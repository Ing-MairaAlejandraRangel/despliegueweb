package com.jdc.tallerdespliegue.repository;

import com.jdc.tallerdespliegue.entity.Estatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstatusRepository extends JpaRepository<Estatus, Integer> {
}
