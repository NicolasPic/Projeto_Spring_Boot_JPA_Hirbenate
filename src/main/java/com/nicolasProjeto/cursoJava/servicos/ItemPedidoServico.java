package com.nicolasProjeto.cursoJava.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolasProjeto.cursoJava.entidades.ItemPedido;
import com.nicolasProjeto.cursoJava.repositorios.ItemPedidoRepositorio;

@Service
public class ItemPedidoServico {

	@Autowired
	private ItemPedidoRepositorio repositorio;

	public List<ItemPedido> encontreTodos() {
		return repositorio.findAll();
	}

	public ItemPedido encontrePorId(Long id) {
		Optional<ItemPedido> obj = repositorio.findById(id);
		return obj.get();
	}
}
