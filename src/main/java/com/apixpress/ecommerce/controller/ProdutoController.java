package com.apixpress.ecommerce.controller;

import java.util.List;

import com.apixpress.ecommerce.model.Produto;
import com.apixpress.ecommerce.repository.ProdutoRepository;

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
@RequestMapping("/produtos")
public class ProdutoController {
 
    @Autowired
    public ProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/valorMaior/{valor}")
    public ResponseEntity<List<Produto>> getAllByValorMaior(@PathVariable float valor) {
        return ResponseEntity.ok(repository.findAllByValorGreaterThanEqual(valor));
    }

    @GetMapping("/valorMenor/{valor}")
    public ResponseEntity<List<Produto>> getAllByValorMenor(@PathVariable float valor) {
        return ResponseEntity.ok(repository.findAllByValorLessThanEqual(valor));
    }

    @GetMapping("/nomeLoja/{nomeLoja}")
    public ResponseEntity<List<Produto>> getAllProdutosByNomeLoja(@PathVariable String nomeLoja) {
        return ResponseEntity.ok(repository.findAllProdutoByNomeLoja(nomeLoja));
    }

    @PostMapping
    public ResponseEntity<Produto> post(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> put(@RequestBody Produto produto) {
        return ResponseEntity.ok(repository.save(produto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }

}
