package com.nicolasProjeto.cursoJava.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nicolasProjeto.cursoJava.entidades.Usuario;
import com.nicolasProjeto.cursoJava.repositorios.UsuarioRepositorio;
import com.nicolasProjeto.cursoJava.servicos.excecoes.DataExcecao;
import com.nicolasProjeto.cursoJava.servicos.excecoes.RecursosNaoEncontradoExcecao;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> encontreTodos() {
		return repositorio.findAll();
	}
	
	public Usuario encontrePorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(()-> new RecursosNaoEncontradoExcecao(id));
	}
	
	public Usuario inserir(Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void delete(Long id) {
		try {
		repositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RecursosNaoEncontradoExcecao(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataExcecao(e.getMessage());
		}
	}
	
	public Usuario update(Long id, Usuario obj) {
		try {
		Usuario entidade = repositorio.getReferenceById(id);
		updateData(entidade, obj);
		return repositorio.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new RecursosNaoEncontradoExcecao(id);
		}
	}

	private void updateData(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setCelular(obj.getCelular());
		
	}
}
