package com.jdc.tallerdespliegue.service;

import com.jdc.tallerdespliegue.entity.Usuario;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<Usuario> listar();
    Optional<Usuario> buscarPorId(Integer id);
    Usuario guardar(Usuario usuario);
    void eliminar(Integer id);
}
