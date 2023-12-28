package com.nicolasProjeto.cursoJava.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolasProjeto.cursoJava.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{

}
