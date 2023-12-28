package com.nicolasProjeto.cursoJava.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolasProjeto.cursoJava.entidades.Categoria;
import com.nicolasProjeto.cursoJava.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServico {

	@Autowired
	private CategoriaRepositorio repositorio;

	public List<Categoria> encontreTodos() {
		return repositorio.findAll();
	}

	public Categoria encontrePorId(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}
}
