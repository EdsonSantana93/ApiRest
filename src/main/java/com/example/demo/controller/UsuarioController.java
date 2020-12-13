package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@GetMapping
	public ResponseEntity<List<Usuario>> buscarTodosUsuarios() {
		List<Usuario> u = new ArrayList<>();
		u.add(new Usuario(null, "Estroncio Silva", "estroncio@gmail.com", "11-99999-9998", "12345"));
		u.add(new Usuario(null, "Dionesia Pereira", "Dionesia@gmail.com", "11-99999-9999", "12345"));
		return ResponseEntity.ok().body(u);
	}

}
