package com.cristian.reservas.business.domain.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.coyote.BadRequestException;

import com.cristian.reservas.business.domain.persistence.entity.Horario;
import com.cristian.reservas.business.domain.persistence.entity.Reserva;
import com.cristian.reservas.business.http.controller.dto.custom.ActualizarReservaDto;
import com.cristian.reservas.business.http.controller.dto.custom.CrearReservaDto;

public interface ReservaService {

	Reserva crear (CrearReservaDto crearReservaDto) throws BadRequestException;
	
	Reserva actualizar(Integer reservarId, ActualizarReservaDto actualizarReservaDto) throws BadRequestException;
	
	Boolean eliminar(Integer reservarId);
	
	Boolean validarDisponibilidad(Horario horario, LocalDate fecha);
	
	List<Reserva> obtenerReservasPorFecha(LocalDate fecha);

}
