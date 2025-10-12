package com.jdc.tallerdespliegue.repository;

import com.jdc.tallerdespliegue.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Buscar usuario por nombre de usuario
    Optional<Usuario> findByUsername(String username);
}
