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
	
	public Usuario incluirUsuario(Usuario usuario) {
		return repository.save(usuario);
	}
	
	public void excluirUsuario(Long id) {
		repository.deleteById(id);
	}
	
	public Usuario atualizarUsuario(Usuario usuario, Long id) {
		Usuario entity = repository.getOne(id);
		atualizarDados(entity, usuario);
		return repository.save(entity);
	}

	private void atualizarDados(Usuario entity, Usuario usuario) {
		entity.setNome(usuario.getNome());
		entity.setEmail(usuario.getEmail());
		entity.setTelefone(usuario.getTelefone());
	}

}
