package com.pge.crudusuario.model;

import java.time.LocalDate;

import com.pge.crudusuario.util.GeneroUsuario;

public class Usuario {
	private Long id;
	private String nome;
	private String cpf;
	private LocalDate dt_nascimento;
	private GeneroUsuario genero;
	private Funcao funcao;
	
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
	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
}