package com.example.demo;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String email;
	private String telefone;
	private String senha;

	protected Usuario() {

	}

	public Usuario(Integer id, String nome, String email, String telefone, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
}
