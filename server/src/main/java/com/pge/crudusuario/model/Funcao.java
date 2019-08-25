package com.pge.crudusuario.model;

import java.util.List;

public class Funcao {
	private Integer id;
	private String nome_funcao;
	private List<Papel> papeis;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome_funcao() {
		return nome_funcao;
	}
	public void setNome_funcao(String nome_funcao) {
		this.nome_funcao = nome_funcao;
	}
	public List<Papel> getPapeis() {
		return papeis;
	}
	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
}
