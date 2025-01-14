package com.cristian.reservas.business.domain.persistence.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reserva", schema = "reservas")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@Column(name = "fecha")
	private LocalDate fecha;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "horario_id")
	private Horario horario;

	@Column(name = "estado")
	private Boolean estado;
}
