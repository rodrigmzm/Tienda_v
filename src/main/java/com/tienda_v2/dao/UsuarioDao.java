package com.tienda_v2.dao;

import com.tienda_v2.domain.Categoria;
import com.tienda_v2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
}
