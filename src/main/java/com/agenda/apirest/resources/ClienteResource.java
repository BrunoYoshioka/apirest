package com.agenda.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.apirest.models.Cliente;
import com.agenda.apirest.repository.ClienteRepository;

@RestController
@RequestMapping(value="/api")
public class ClienteResource {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listaClientes(){
		return clienteRepository.findAll();
	}
	
	/*@GetMapping("/cliente/{id}")
	public Cliente listaClienteUnico(@PathVariable(value = "id") long id){
		return clienteRepository.findById(id);
	}*/
	
}
