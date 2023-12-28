package com.nicolasProjeto.cursoJava.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolasProjeto.cursoJava.entidades.Pedido;
import com.nicolasProjeto.cursoJava.repositorios.PedidoRepositorio;

@Service
public class PedidoServico {

	@Autowired
	private PedidoRepositorio repositorio;
	
	public List<Pedido> encontreTodos() {
		return repositorio.findAll();
	}
	
	public Pedido encontrePorId(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}
}
