package com.nicolasProjeto.cursoJava.recursos;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolasProjeto.cursoJava.entidades.Produto;
import com.nicolasProjeto.cursoJava.servicos.ProdutoServico;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRecurso {
	@Autowired
	private ProdutoServico servico;
	
	@GetMapping
	public ResponseEntity<List<Produto>> encontreTodos(){
		List<Produto> lista = servico.encontreTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> encontrePorId(@PathVariable Long id) {
		Produto obj = servico.encontrePorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
