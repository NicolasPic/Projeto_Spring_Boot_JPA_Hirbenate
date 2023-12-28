package com.nicolasProjeto.cursoJava.recursos.excecoes;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nicolasProjeto.cursoJava.servicos.excecoes.DataExcecao;
import com.nicolasProjeto.cursoJava.servicos.excecoes.RecursosNaoEncontradoExcecao;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ManipuladorDeExcecaoDeRecurso {

	@ExceptionHandler(RecursosNaoEncontradoExcecao.class)
	public ResponseEntity<ErrorPadrao> recursoNãoEncontrado(RecursosNaoEncontradoExcecao r, HttpServletRequest request) {
		String error ="recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorPadrao err = new ErrorPadrao(Instant.now(), status.value(), error, r.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataExcecao.class)
	public ResponseEntity<ErrorPadrao> database(DataExcecao e, HttpServletRequest request) {
		String error ="erro no banco de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErrorPadrao err = new ErrorPadrao(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
