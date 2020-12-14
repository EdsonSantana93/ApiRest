package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Pedido;
import com.example.demo.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService service;

	@GetMapping
	public ResponseEntity<List<Pedido>> buscarTodospedidos() {
		List<Pedido> pedidos = service.buscarPedidos();
		return ResponseEntity.ok().body(pedidos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> buscarUsuarioId(@PathVariable Long id) {
		Pedido pedido = service.buscarUsuarioId(id);
		return ResponseEntity.ok().body(pedido);
	}

}
