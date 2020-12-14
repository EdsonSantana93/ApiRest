package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Pedido;
import com.example.demo.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public List<Pedido> buscarPedidos(){
		return repository.findAll();
	}

	public Pedido buscarUsuarioId(Long id) {
		Pedido pedido = repository.findById(id).get();
		return pedido;
	}

}
