package com.apixpress.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_lojas")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLoja;

    @NotNull
    @Size(max = 45)
    private String nomeLoja;

    @NotNull
    @Size(max = 100)
    private String descricaoLoja;

    @OneToMany(mappedBy = "loja", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("loja")
    private List<Produto> produto;

    @ManyToOne
    @JsonIgnoreProperties("loja")
    private Usuario usuario;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
	  name = "inscricao", 
	  joinColumns = @JoinColumn(name = "loja_idLoja"), 
	  inverseJoinColumns = @JoinColumn(name = "usuario_idUsuario")
	  )
	@JsonIgnoreProperties({"nome", "usuario", "senha", "produto", "loja", "inscricoes"})
	private List<Usuario> usuarios = new ArrayList<>();

    public long getIdLoja() {
        return this.idLoja;
    }

    public void setIdLoja(long idLoja) {
        this.idLoja = idLoja;
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public String getDescricaoLoja() {
        return this.descricaoLoja;
    }

    public void setDescricaoLoja(String descricaoLoja) {
        this.descricaoLoja = descricaoLoja;
    }

    public List<Produto> getProduto() {
        return this.produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
