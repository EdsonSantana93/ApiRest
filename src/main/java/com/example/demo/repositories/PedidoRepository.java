package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
