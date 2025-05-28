package com.generation.farmacia.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.farmacia.model.Produto;
import com.generation.farmacia.repository.CategoriaRepository;
import com.generation.farmacia.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {

		return ResponseEntity.ok(produtoRepository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id) {

		return produtoRepository.findById(id).map(produto -> ResponseEntity.ok(produto))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getAllByNome(@PathVariable String nome) {
		List<Produto> produtos = produtoRepository.findAllByNomeContainingIgnoreCase(nome);
		if (produtos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(produtos);
	}

	@PostMapping
	public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto) {
		// Garante que o ID da categoria não seja nulo e que a categoria exista
		if (produto.getCategoria() == null || produto.getCategoria().getId() == null
				|| !categoriaRepository.existsById(produto.getCategoria().getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A categoria informada não existe ou é inválida!",
					null);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Produto> put(@Valid @RequestBody Produto produto) {
		if (produto.getId() == null || !produtoRepository.existsById(produto.getId())) {
			return ResponseEntity.notFound().build();
		}

		return categoriaRepository.findById(produto.getCategoria().getId()).map(categoria -> {
			produto.setCategoria(categoria);
			return ResponseEntity.ok(produtoRepository.save(produto));
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "A categoria não existe!"));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {

		Optional<Produto> produtoOptional = produtoRepository.findById(id);

		if (produtoOptional.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado para exclusão!");
		}
		
		produtoRepository.deleteById(id);

	}

	// GET por preço maior que
	@GetMapping("/preco_maior/{preco}")
	public ResponseEntity<List<Produto>> getByPrecoMaior(@PathVariable Double preco) {
		return ResponseEntity.ok(produtoRepository.findAllByPrecoGreaterThan(preco));
	}

	// GET por preço menor que
	@GetMapping("/preco_menor/{preco}")
	public ResponseEntity<List<Produto>> getByPrecoMenor(@PathVariable Double preco) {
		return ResponseEntity.ok(produtoRepository.findAllByPrecoLessThan(preco));
	}

}