package com.nicolasProjeto.cursoJava.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolasProjeto.cursoJava.entidades.Categoria;
import com.nicolasProjeto.cursoJava.servicos.CategoriaServico;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecurso {
	
	@Autowired
	private CategoriaServico servico;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> encontreTodos(){
		List<Categoria> lista = servico.encontreTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> encontrePorId(@PathVariable Long id) {
		Categoria obj = servico.encontrePorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
