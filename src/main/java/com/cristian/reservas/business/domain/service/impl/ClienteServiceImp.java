package com.cristian.reservas.business.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.reservas.business.domain.persistence.entity.Cliente;
import com.cristian.reservas.business.domain.persistence.repository.ClienteRespository;
import com.cristian.reservas.business.domain.service.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService {

	@Autowired
	ClienteRespository clienteRespository;

	@Override
	public Cliente crear(Cliente cliente) {
		
		cliente.setEstado(true);

		return clienteRespository.save(cliente);
	}

}
