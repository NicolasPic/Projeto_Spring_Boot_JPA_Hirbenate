package com.nicolasProjeto.cursoJava.servicos;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolasProjeto.cursoJava.entidades.Produto;
import com.nicolasProjeto.cursoJava.repositorios.ProdutoRepositorio;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio repositorio;

	public List<Produto> encontreTodos() {
		return repositorio.findAll();
	}

	public Produto encontrePorId(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}
}
