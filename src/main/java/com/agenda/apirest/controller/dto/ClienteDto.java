package com.agenda.apirest.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.agenda.apirest.models.Cliente;

public class ClienteDto {
	
	private Long id;
	private String nome;
	private String endereco;
	private String email;
	private String sexo;
	private String telefone;
	private String celular;
	
	public ClienteDto(Cliente cliente) {
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
	
	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}

}
