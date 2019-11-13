package com.agenda.apirest.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.agenda.apirest.controller.dto.ClienteDto;
import com.agenda.apirest.models.Cliente;

@Component
public class EnviarClienteJms {
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void enviarCliente(Cliente cliente) {
		jmsTemplate.convertAndSend("clienteQueue", cliente);
	}
}
