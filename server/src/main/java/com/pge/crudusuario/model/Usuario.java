package com.pge.crudusuario.model;

import java.time.LocalDate;

import com.pge.crudusuario.util.GeneroUsuario;

public class Usuario {
	private Long id;
	private String name;
	private String cpf;
	private LocalDate dt_nascimento;
	private GeneroUsuario genero;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDt_nascimento() {
		return dt_nascimento;
	}
	public void setDt_nascimento(LocalDate dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	public GeneroUsuario getGenero() {
		return genero;
	}
	public void setGenero(GeneroUsuario genero) {
		this.genero = genero;
	}
	
}