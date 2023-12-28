package com.nicolasProjeto.cursoJava.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolasProjeto.cursoJava.entidades.Pedido;
import com.nicolasProjeto.cursoJava.servicos.PedidoServico;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoRecurso {
	
	@Autowired
	private PedidoServico servico;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> encontreTodos(){
		List<Pedido> lista = servico.encontreTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> encontrePorId(@PathVariable Long id) {
		Pedido obj = servico.encontrePorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
