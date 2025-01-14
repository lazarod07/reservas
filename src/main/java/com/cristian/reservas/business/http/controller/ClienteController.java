package com.cristian.reservas.business.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristian.reservas.business.domain.persistence.entity.Cliente;
import com.cristian.reservas.business.domain.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@PostMapping("/crear")
	public Cliente crear(@RequestBody(required = true) Cliente cliente) {

		return clienteService.crear(cliente);

	}

}
