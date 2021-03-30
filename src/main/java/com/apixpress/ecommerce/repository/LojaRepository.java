package com.apixpress.ecommerce.repository;

import java.util.List;

import com.apixpress.ecommerce.model.Loja;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Long> {

    public List<Loja> findAllByNomeLojaContainingIgnoreCase(String nomeLoja);
    
}
