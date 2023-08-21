package com.GameSphere.dao;

import com.GameSphere.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {    

    Usuario findByUsername(String username);
    
    @Override
    Usuario save(Usuario usuario);
    
}
