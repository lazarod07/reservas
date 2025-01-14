package com.cristian.reservas.business.domain.persistence.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristian.reservas.business.domain.persistence.entity.Horario;
import com.cristian.reservas.business.domain.persistence.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

	Optional<Reserva> findByFechaAndHorarioAndEstado(LocalDate fecha, Horario horario, Boolean estado);

	List<Reserva> findByFecha(LocalDate fecha);

}
