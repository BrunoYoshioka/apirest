package com.agenda.apirest.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.agenda.apirest.models.Cliente;
import com.agenda.apirest.repository.ClienteRepository;

public class ClienteForm {
	
	private Long id;
	@NotNull @NotEmpty @Length(min = 5)
	private String nome;
	@NotNull @NotEmpty
	private String endereco;
	@NotNull @NotEmpty @Length(min = 5)
	private String email;
	@NotNull @NotEmpty
	private String sexo;
	@NotNull @NotEmpty
	private String telefone;
	@NotNull @NotEmpty
	private String celular;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/*public Cliente converter(ClienteRepository clienteRepository) {
		Cliente idCliente = clienteRepository.findById(id);
		return new Cliente(nome, endereco, email, sexo, telefone, celular, idCliente);
	}*/
	
}
