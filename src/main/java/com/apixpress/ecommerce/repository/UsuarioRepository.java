package com.apixpress.ecommerce.repository;

import java.util.List;

import com.apixpress.ecommerce.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    public List<Usuario> findAllByNomeUsuarioContainingIgnoreCase(String nomeUsuario);

}
