package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Usuario;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> buscarUsuarios(){
		return repository.findAll();
	}

	public Usuario buscarUsuarioId(Long id) {
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.get();
	}

}
