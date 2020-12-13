package com.example.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.Usuario;
import com.example.demo.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Estroncio Silva", "estroncio@gmail.com", "11-99999-9998", "12345");
		Usuario u2 = new Usuario(null, "Dionesia Pereira", "dionesia@gmail.com", "11-99999-9999", "12345");
		Usuario u3 = new Usuario(null, "Mariazinha Lopes", "mariazinha@gmail.com", "11-99999-9997", "55687");

		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));
	}

}
