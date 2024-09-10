package com.example.produtoservicedocker.repository;

import com.example.produtoservicedocker.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
