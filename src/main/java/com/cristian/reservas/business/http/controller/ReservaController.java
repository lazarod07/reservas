package com.cristian.reservas.business.http.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristian.reservas.business.domain.persistence.entity.Reserva;
import com.cristian.reservas.business.domain.service.ReservaService;
import com.cristian.reservas.business.http.controller.dto.custom.ActualizarReservaDto;
import com.cristian.reservas.business.http.controller.dto.custom.CrearReservaDto;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	ReservaService reservaService;

	@PostMapping("/crear")
	Reserva crear(@RequestBody(required = true) CrearReservaDto crearReservaDto) throws BadRequestException {
		return reservaService.crear(crearReservaDto);
	}

	@PutMapping("/actualizar/{reservarId}")
	Reserva actualizar(@PathVariable Integer reservarId,
			@RequestBody(required = true) ActualizarReservaDto actualizarReservaDto) throws BadRequestException {
		return reservaService.actualizar(reservarId, actualizarReservaDto);

	}

	@DeleteMapping("/eliminar/{reservarId}")
	Boolean eliminar(@PathVariable Integer reservarId) {
		return reservaService.eliminar(reservarId);
	}

	@GetMapping
	List<Reserva> obtenerReservasPorFecha(LocalDate fecha) {
		return reservaService.obtenerReservasPorFecha(fecha);
	}

}
