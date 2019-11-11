package com.agenda.apirest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.agenda.apirest.controller.dto.ClienteDto;
import com.agenda.apirest.controller.dto.DetalhesDoClienteDto;
import com.agenda.apirest.controller.form.AtualizacaoClienteForm;
import com.agenda.apirest.controller.form.ClienteForm;
import com.agenda.apirest.models.Cliente;
import com.agenda.apirest.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/clientes")
@Api("API REST Agenda Clientes")
@CrossOrigin(origins="*") // definir qual dominio irá ser liberado, no meu caso todos
public class ClientesController {
	
	//Injetando o ClienteRepository
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping //Metodo Listar Todos os Clientes
	@ApiOperation(value="Retorna uma lista de clientes ou filtro por nome")
	public List<ClienteDto> lista(String nomeCliente){
		//Se não tiver parametro
		if (nomeCliente == null) {
			List<Cliente> clientes = clienteRepository.findAll();
			return ClienteDto.converter(clientes);
		} 
		//Se tiver filtro por nome
		else {
			// Ele irá listar o cliente único
			// Link de Exemplo: http://localhost:8080/clientes?nomeCliente=leticia+brito
			List<Cliente> clientes = clienteRepository.findByNome(nomeCliente);
			return ClienteDto.converter(clientes);
		}
	}
	
	@GetMapping("/{id}") // Listar apenas um registro
	@ApiOperation(value="Retorna unico cliente por Id")
	public ResponseEntity<DetalhesDoClienteDto> detalhar(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoClienteDto(cliente.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping //Metodo cadastrar
	@ApiOperation(value="Cadastrar cliente numa agenda")
	public Cliente cadastraCliente (@RequestBody @Valid Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	/*@PostMapping //Metodo cadastrar
	@ApiOperation(value="Cadastrar cliente numa agenda")
	@Transactional
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteDto form, UriComponentsBuilder uriBuilder) {
		Cliente topico = form.converter(clienteRepository);
		clienteRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(topico));
	}*/
	
	@PutMapping("/{id}") //Método atualizar
	@ApiOperation(value="Atualizar cliente numa agenda")
	@Transactional // Usar essa anotação para disparar commit no banco
	public ResponseEntity<ClienteDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoClienteForm form) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()) {
			Cliente cliente = form.atualizar(id, clienteRepository);
			return ResponseEntity.ok(new ClienteDto(cliente));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}") //Excluir cliente
	@ApiOperation(value="Remover cliente numa agenda")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
