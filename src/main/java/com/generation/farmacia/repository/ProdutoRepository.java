package com.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	// Buscar por nome
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);

	// Produtos com preço maior que
	public List<Produto> findAllByPrecoGreaterThan(Double preco);

	// Produtos com preço menor que
	public List<Produto> findAllByPrecoLessThan(Double preco);
}