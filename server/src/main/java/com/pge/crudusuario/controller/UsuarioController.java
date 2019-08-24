package com.pge.crudusuario.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pge.crudusuario.model.Usuario;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsuarioController {

	private List<Usuario> usuarios = adicionaUsuariosFake();
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public List<Usuario> getUsuariosCadastrados() {
		return usuarios;
	}
	
	private static List<Usuario> adicionaUsuariosFake() {
		List<Usuario> usuarios = new ArrayList<>();
		Usuario usuario = new Usuario();
		usuario.setNome("Jefferson");
		usuario.setCpf("058.333.444-55");
		usuarios.add(usuario);
		
		usuario = new Usuario();
		usuario.setNome("Barbosa");
		usuario.setCpf("038.123.456-70");
		usuarios.add(usuario);
		
		return usuarios;
	}
}