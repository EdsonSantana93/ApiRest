package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Produto;
import com.example.demo.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodosProdutos(){
		List<Produto> produtos = service.buscarProdutos();
		return ResponseEntity.ok().body(produtos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarProdutoId(@PathVariable Long id){
		Produto produto = service.BuscarPorId(id);
		return ResponseEntity.ok().body(produto);
	}
}
