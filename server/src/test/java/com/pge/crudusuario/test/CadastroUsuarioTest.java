package com.pge.crudusuario.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;

import com.pge.crudusuario.controller.UsuarioController;
import com.pge.crudusuario.model.Funcao;
import com.pge.crudusuario.model.Papel;
import com.pge.crudusuario.model.Usuario;
import com.pge.crudusuario.util.GeneroUsuario;

public class CadastroUsuarioTest {

	public Usuario instanceUsuario() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("Jefferson");
		usuario.setCpf("058.333.444-55");
		usuario.setDt_nascimento(LocalDate.now());
		usuario.setGenero(GeneroUsuario.MASCULINO);
		Funcao funcao = new Funcao();
		funcao.setNome_funcao("Teste de funcao");
		ArrayList<Papel> papeis = new ArrayList<Papel>();
		Papel papel = new Papel();
		papel.setNome_papel("Teste papel");
		papeis.add(papel);
		funcao.setPapeis(papeis);
		usuario.setFuncao(funcao);
		return usuario;
	}
	
	@Test
	public void getUsuarios() {
		UsuarioController user_control =  new UsuarioController();
		Usuario usuario = instanceUsuario();
		user_control.create(usuario);
		user_control.create(usuario);
		assertTrue(user_control.getUsuariosCadastrados().size() == 2);
	}
	
	@Test
	public void cadastroUsuarioCompleto() {
		UsuarioController user_control =  new UsuarioController();
		Usuario usuario = instanceUsuario();
		user_control.create(usuario);
		assertTrue(user_control.getUsuariosCadastrados().size() == 1 && 
				user_control.getUsuariosCadastrados().contains(usuario));
	}
	
	@Test
	public void deletarUsuario() {
		UsuarioController user_control =  new UsuarioController();
		Usuario usuario = instanceUsuario();
		user_control.create(usuario);
		user_control.delete(usuario.getId());
		assertTrue(user_control.getUsuariosCadastrados().isEmpty());
	}

}
