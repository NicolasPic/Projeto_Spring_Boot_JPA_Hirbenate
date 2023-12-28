package com.nicolasProjeto.cursoJava.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nicolasProjeto.cursoJava.entidades.Usuario;
import com.nicolasProjeto.cursoJava.servicos.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {
	
	@Autowired
	private UsuarioServico servico;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> encontreTodos(){
		List<Usuario> lista = servico.encontreTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> encontrePorId(@PathVariable Long id) {
		Usuario obj = servico.encontrePorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario obj) {
		obj = servico.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id,@RequestBody Usuario obj) {
		obj = servico.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
