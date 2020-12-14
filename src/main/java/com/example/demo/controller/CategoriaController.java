package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Categoria;
import com.example.demo.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodasCategorias() {
		List<Categoria> categorias = service.buscarTodos();

		return ResponseEntity.ok().body(categorias);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarCategoriaId(@PathVariable Long id) {
		Categoria categoria = service.buscaCategoriaId(id);

		return ResponseEntity.ok().body(categoria);
	}
}
