package com.example.demo.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataHoraPedido;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Usuario cliente;

	protected Pedido() {

	}

	public Pedido(Long id, Instant dataHoraPedido, Usuario cliente) {
		super();
		this.id = id;
		this.dataHoraPedido = dataHoraPedido;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataHoraPedido() {
		return dataHoraPedido;
	}

	public void setDataHoraPedido(Instant dataHoraPedido) {
		this.dataHoraPedido = dataHoraPedido;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
}