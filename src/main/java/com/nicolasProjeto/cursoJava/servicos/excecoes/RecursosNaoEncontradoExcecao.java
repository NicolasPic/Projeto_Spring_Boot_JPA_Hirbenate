package com.nicolasProjeto.cursoJava.servicos.excecoes;

public class RecursosNaoEncontradoExcecao extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RecursosNaoEncontradoExcecao(Object id) {
		super("Recurso não encontrado. ID: " + id);
	}
}
