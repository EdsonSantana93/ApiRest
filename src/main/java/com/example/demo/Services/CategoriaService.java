package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Categoria;
import com.example.demo.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> buscarTodos() {
		return repository.findAll();
	}

	public Categoria buscaCategoriaId(Long id) {
		Categoria categoria = repository.findById(id).get();
		return categoria;
	}
}
