package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Produto;
import com.example.demo.repositories.ProdutoRepository;

@Service
public class ProdutoService{
	
	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> buscarProdutos(){
		return repository.findAll();
	}
	
	public Produto BuscarPorId(Long id) {
		Produto produto = repository.findById(id).get();
		return produto;
	}
}
