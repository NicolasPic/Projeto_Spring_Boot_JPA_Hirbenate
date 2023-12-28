package com.nicolasProjeto.cursoJava.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolasProjeto.cursoJava.entidades.ItemPedido;
import com.nicolasProjeto.cursoJava.servicos.ItemPedidoServico;

@RestController
@RequestMapping(value = "/itensPedido")
public class ItemPedidoRecurso {
	
	@Autowired
	private ItemPedidoServico servico;
	
	@GetMapping
	public ResponseEntity<List<ItemPedido>> encontreTodos(){
		List<ItemPedido> lista = servico.encontreTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItemPedido> encontrePorId(@PathVariable Long id) {
		ItemPedido obj = servico.encontrePorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
