package com.example.produtoservicedocker.service;

import com.example.produtoservicedocker.model.Produto;
import com.example.produtoservicedocker.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }
    public Optional<Produto> findById(Long id){
        return produtoRepository.findById(id);
    }
    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }
    public void delete(Long id){
        produtoRepository.deleteById(id);
    }
}
