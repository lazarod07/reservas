package com.cristian.reservas.business.domain.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cristian.reservas.business.domain.persistence.entity.Cliente;
import com.cristian.reservas.business.domain.persistence.entity.Horario;
import com.cristian.reservas.business.domain.persistence.entity.Reserva;
import com.cristian.reservas.business.domain.persistence.repository.ClienteRespository;
import com.cristian.reservas.business.domain.persistence.repository.HorarioRepository;
import com.cristian.reservas.business.domain.persistence.repository.ReservaRepository;
import com.cristian.reservas.business.domain.service.ReservaService;
import com.cristian.reservas.business.http.controller.dto.custom.ActualizarReservaDto;
import com.cristian.reservas.business.http.controller.dto.custom.CrearReservaDto;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	ReservaRepository reservaRepository;

	@Autowired
	ClienteRespository clienteRespository;

	@Autowired
	HorarioRepository horarioRepository;

	@Override
	public Reserva crear(CrearReservaDto crearReservaDto) throws BadRequestException {

		Cliente cliente = clienteRespository.findById(crearReservaDto.getClienteId())
				.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

		Horario horario = horarioRepository.findById(crearReservaDto.getHorario())
				.orElseThrow(() -> new IllegalArgumentException("Horario no encontrado"));

		Boolean noDisponibilidad = validarDisponibilidad(horario, crearReservaDto.getFecha());

		if (noDisponibilidad)
			throw new BadRequestException("Este espacio no se encuentra disponible");

		Reserva reserva = new Reserva();

		reserva.setCliente(cliente);
		reserva.setFecha(crearReservaDto.getFecha());
		reserva.setHorario(horario);
		reserva.setEstado(true);

		reserva = reservaRepository.save(reserva);

		return reserva;
	}

	@Override
	public Boolean validarDisponibilidad(Horario horario, LocalDate fecha) {

		return reservaRepository.findByFechaAndHorarioAndEstado(fecha, horario, Boolean.TRUE).isPresent();
	}

	@Override
	public Reserva actualizar(Integer reservarId, ActualizarReservaDto actualizarReservaDto)
			throws BadRequestException {

		Reserva reserva = reservaRepository.findById(reservarId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada"));

		Cliente cliente = clienteRespository.findById(actualizarReservaDto.getClienteId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));

		Horario horario = horarioRepository.findById(actualizarReservaDto.getHorario())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Horario no encontrado"));

		Boolean noDisponibilidad = validarDisponibilidad(horario, actualizarReservaDto.getFecha());

		if (noDisponibilidad)
			throw new BadRequestException("Este espacio no se encuentra disponible");

		reserva = new Reserva();

		reserva.setId(reservarId);
		reserva.setCliente(cliente);
		reserva.setFecha(actualizarReservaDto.getFecha());
		reserva.setHorario(horario);
		reserva.setEstado(actualizarReservaDto.getEstado());

		reserva = reservaRepository.save(reserva);

		return reserva;
	}

	@Override
	public Boolean eliminar(Integer reservarId) {

		Reserva reserva = reservaRepository.findById(reservarId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada"));

		reservaRepository.delete(reserva);

		return Boolean.TRUE;
	}

	@Override
	public List<Reserva> obtenerReservasPorFecha(LocalDate fecha) {
		
		return reservaRepository.findByFecha(fecha);
	}

}
