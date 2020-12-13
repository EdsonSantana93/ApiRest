package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.Pedido;
import com.example.demo.entities.Usuario;
import com.example.demo.repositories.PedidoRepository;
import com.example.demo.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Estroncio Silva", "estroncio@gmail.com", "11-99999-9998", "12345");
		Usuario u2 = new Usuario(null, "Dionesia Pereira", "dionesia@gmail.com", "11-99999-9999", "12345");
		Usuario u3 = new Usuario(null, "Mariazinha Lopes", "mariazinha@gmail.com", "11-99999-9997", "55687");

		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));
		Pedido p1 = new Pedido(null, Instant.parse("2020-06-20T19:53:07Z"), u1);
		Pedido p2 = new Pedido(null, Instant.parse("2020-10-05T15:48:33Z"), u2);
		Pedido p3 = new Pedido(null, Instant.parse("2020-12-12T18:15:14Z"), u1);

		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
