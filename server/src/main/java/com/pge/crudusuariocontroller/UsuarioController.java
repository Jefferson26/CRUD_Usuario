package com.pge.crudusuariocontroller;


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

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public List<Usuario> getUsuariosCadastrados() {
		return usuarios;
	}
}