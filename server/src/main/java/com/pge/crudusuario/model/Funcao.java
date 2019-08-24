package com.pge.crudusuario.model;

import java.util.List;

public class Funcao {
	private Long id;
	private String nome_funcao;
	private List<Papel> papeis_funcao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome_funcao() {
		return nome_funcao;
	}
	public void setNome_funcao(String nome_funcao) {
		this.nome_funcao = nome_funcao;
	}
	public List<Papel> getPapeis_funcao() {
		return papeis_funcao;
	}
	public void setPapeis_funcao(List<Papel> papeis_funcao) {
		this.papeis_funcao = papeis_funcao;
	}
}
