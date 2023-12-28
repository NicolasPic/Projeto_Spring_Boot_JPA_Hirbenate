package com.nicolasProjeto.cursoJava.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolasProjeto.cursoJava.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{

}
