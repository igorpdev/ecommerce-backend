package com.apixpress.ecommerce.repository;

import java.util.List;

import com.apixpress.ecommerce.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    public List<Produto> findAllByValorLessThanEqual (float valor);
	
	public List<Produto> findAllByValorGreaterThanEqual (float valor);

    @Query(value = "select * from tb_produtos inner join tb_lojas on tb_lojas.idLoja = tb_produtos.loja_id_loja where tb_loja.nomeLoja = :nomeLoja", nativeQuery = true)
	public List<Produto> findAllProdutoByNomeLoja(@Param("nomeLoja") String nomeLoja);

}
