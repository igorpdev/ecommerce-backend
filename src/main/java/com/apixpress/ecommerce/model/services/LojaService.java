package com.apixpress.ecommerce.model.services;

import java.util.Optional;

import com.apixpress.ecommerce.model.Loja;
import com.apixpress.ecommerce.model.Produto;
import com.apixpress.ecommerce.repository.LojaRepository;
import com.apixpress.ecommerce.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private LojaRepository lojaRepository;

    public Loja cadastroProdutoLoja(long lojaId, long produtoId) {

        Optional<Produto> produtoExistente = produtoRepository.findById(produtoId);
        Optional<Loja> lojaExistente = lojaRepository.findById(lojaId);

        if (produtoExistente.isPresent() && lojaExistente.isPresent()) {

            lojaExistente.get().getProduto().add(produtoExistente.get());

            lojaRepository.save(lojaExistente.get());

            return lojaRepository.save(lojaExistente.get());
        }
        return null;

    }

}
