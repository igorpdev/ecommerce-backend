package com.apixpress.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
@Entity
@Table(name = "tb_inscricao")
public class Inscricao {
    
    @ManyToOne
    @JsonIgnoreProperties("inscricao")
    private Usuario usuario;

    @ManyToOne
    @JsonIgnoreProperties("inscricao")
    private Loja loja;

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Loja getLoja() {
        return this.loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

}
*/
