package com.nicolasProjeto.cursoJava.servicos.excecoes;

public class DataExcecao extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DataExcecao(String msg) {
		super(msg);
	}

}
