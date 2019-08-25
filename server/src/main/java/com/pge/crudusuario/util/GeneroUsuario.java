package com.pge.crudusuario.util;

public enum GeneroUsuario {
    MASCULINO(0),
    FEMININO(1), 
    INDEFINIDO(2); 
	
	private final int genero;
	GeneroUsuario(int genero){
		this.genero = genero;
    }
	public int getGenero(){
        return genero;
    }
}
