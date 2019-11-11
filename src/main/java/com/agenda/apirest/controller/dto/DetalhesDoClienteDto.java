package com.agenda.apirest.controller.dto;

import com.agenda.apirest.models.Cliente;

public class DetalhesDoClienteDto {
	
	private Long id;
	private String nome;
	private String endereco;
	private String email;
	private String sexo;
	private String telefone;
	private String celular;
	
	public DetalhesDoClienteDto(Cliente cliente) {
		
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.endereco = cliente.getEndereco();
		this.email = cliente.getEmail();
		this.sexo = cliente.getSexo();
		this.telefone = cliente.getTelefone();
		this.celular = cliente.getCelular();
		
		
		
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getEmail() {
		return email;
	}

	public String getSexo() {
		return sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCelular() {
		return celular;
	}
	
	

}
