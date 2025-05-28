package com.generation.farmacia.util;

import java.time.LocalDate;

import com.generation.farmacia.model.Usuario;
import com.generation.farmacia.model.UsuarioLogin;

public class TestBuilder {

	public static Usuario criarUsuario(Long id, String nome, String email, String senha, LocalDate dataNascimento) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(nome);
		usuario.setUsuario(email);
		usuario.setSenha(senha);
		usuario.setFoto("-");
		usuario.setDataNascimento(dataNascimento);
		return usuario;
	}

	public static Usuario criarUsuarioRoot() {
		// Exemplo de data de nascimento válida
		return criarUsuario(null, "Root", "root@root.com", "rootroot", LocalDate.of(2000, 1, 1));
	}

	public static UsuarioLogin criarUsuario(String email, String senha) {
		UsuarioLogin usuarioLogin = new UsuarioLogin();
		usuarioLogin.setUsuario(email);
		usuarioLogin.setSenha(senha);
		return usuarioLogin;
	}
}
