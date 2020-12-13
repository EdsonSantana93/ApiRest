package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Usuario;
import com.example.demo.Services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> buscarTodosUsuarios() {
		List<Usuario> usuarios = service.buscarUsuarios();
		return ResponseEntity.ok().body(usuarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarUsuarioId(@PathVariable Long id){
		Usuario usuario = service.buscarUsuarioId(id);
		return ResponseEntity.ok().body(usuario);
	}		

}
