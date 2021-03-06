package com.apixpress.ecommerce.controller;

import java.util.List;

import com.apixpress.ecommerce.model.Loja;
import com.apixpress.ecommerce.model.services.LojaService;
import com.apixpress.ecommerce.repository.LojaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/lojas")
public class LojaController {

    @Autowired
    public LojaRepository repository;

    @Autowired
    public LojaService service;

    @GetMapping
    public ResponseEntity<List<Loja>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loja> getById(@PathVariable long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("nomeLoja/{nomeLoja}")
    public ResponseEntity<List<Loja>> getByNomeLoja(@PathVariable String nomeLoja) {
        return ResponseEntity.ok(repository.findAllByNomeLojaContainingIgnoreCase(nomeLoja));
    }

    @PostMapping
    public ResponseEntity<Loja> post(@RequestBody Loja loja) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(loja));
    }

    @PostMapping("/lojaProduto/loja/{lojaId}/produto/{produtoId}")
    public ResponseEntity<Loja> postCategoriaProduto(@PathVariable long lojaId, @PathVariable long produtoId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastroProdutoLoja(lojaId, produtoId));
    }

    @PutMapping
    public ResponseEntity<Loja> put(@RequestBody Loja loja) {
        return ResponseEntity.ok(repository.save(loja));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }

}
