package com.agenda.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.apirest.models.Cliente;
// usar JpaRepository para facilitar a vida do desenvolvedor, pq o JPA repository ja possui vários metodos prontos pra fazer persistencia no banco
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Cliente findById(long id);

	List<Cliente> findByNome(String nomeCliente);
}