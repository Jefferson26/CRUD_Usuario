package com.pge.crudusuario.controller;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pge.crudusuario.model.Funcao;
import com.pge.crudusuario.model.Usuario;
import com.pge.crudusuario.util.GeneroUsuario;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsuarioController {

	private List<Usuario> usuarios = adicionaUsuariosFake();
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public List<Usuario> getUsuariosCadastrados() {
		return usuarios;
	}
	
	@DeleteMapping(path = { "/{id}" })
	public Usuario delete(@PathVariable("id") Integer id) {	
		
		Usuario usuario_removido = usuarios.stream().filter(
														c -> c.getId().equals(id)
													).findFirst().get();	
		usuarios.remove(usuario_removido);
		return usuario_removido;
	}

	@PostMapping
	public Usuario create(@RequestBody Usuario usuario) {
		usuario.setId(usuarios.size());
		usuarios.add(usuario);
		return usuario;
	}
	
	private static List<Usuario> adicionaUsuariosFake() {
		List<Usuario> usuarios = new ArrayList<>();
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("Jefferson");
		usuario.setCpf("058.333.444-55");
		usuario.setDt_nascimento(LocalDate.now());
		usuario.setGenero(GeneroUsuario.MASCULINO);
		Funcao funcao = new Funcao();
		funcao.setNome_funcao("Teste de funcao");
		usuario.setFuncao(funcao);
		usuarios.add(usuario);
		
		usuario = new Usuario();
		usuario.setId(2);
		usuario.setNome("Barbosa");
		usuario.setCpf("038.123.456-70");
		usuario.setDt_nascimento(LocalDate.now());
		usuario.setGenero(GeneroUsuario.INDEFINIDO);
		funcao = new Funcao();
		funcao.setNome_funcao("Usuario Comum");
		usuario.setFuncao(funcao);
		usuarios.add(usuario);
		
		return usuarios;
	}
}