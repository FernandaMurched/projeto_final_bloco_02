package com.generation.farmacia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Long id;

	@Column(length = 100)
	@NotBlank(message = "É obrigatório preencher o atributo nome!")
	@Size(min = 2, max = 100, message = "O atributo nome deve ter no mínimo 2 e no máximo 100 caracteres.")
	private String nome;

	@NotNull(message = "O atributo preço é obrigatório!")
	@Positive(message = "O preço deve ser maior que zero!")
	private Double preco;

	@NotNull(message = "É obrigatório preencher o atributo quantidade em estoque!")
	@Positive(message = "A quantidade em estoque deve ser maior ou igual a zero!")																		// negativa. Ajustei a mensagem.
	private Integer quantidadeEstoque;

	@Column(length = 5000)
	private String foto;

	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

}
