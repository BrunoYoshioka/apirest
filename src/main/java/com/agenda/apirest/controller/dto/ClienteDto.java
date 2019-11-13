package com.agenda.apirest.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.agenda.apirest.models.Cliente;

public class ClienteDto {
	
	private String nome;
	private String endereco;
	private String email;
	private String sexo;
	private String telefone;
	private String celular;
	
	public ClienteDto() {
		
	}
	
	public ClienteDto(Cliente cliente) {
		this.nome = cliente.getNome();
		this.endereco = cliente.getEndereco();
		this.email = cliente.getEmail();
		this.sexo = cliente.getSexo();
		this.telefone = cliente.getTelefone();
		this.celular = cliente.getCelular();
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setCelular(String celular) {
		this.celular = celular;
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
