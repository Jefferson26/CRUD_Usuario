package com.pge.crudusuario.controller;

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

import com.pge.crudusuario.model.Usuario;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsuarioController {

	private List<Usuario> usuarios = new ArrayList<>();
	
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
}