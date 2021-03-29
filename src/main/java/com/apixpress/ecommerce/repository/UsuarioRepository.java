package com.apixpress.ecommerce.repository;

import com.apixpress.ecommerce.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
