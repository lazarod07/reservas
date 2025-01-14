package com.cristian.reservas.business.http.controller.dto.custom;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActualizarReservaDto implements Serializable {

	private static final long serialVersionUID = -5750203345952809262L;

	private Integer clienteId;

	private LocalDate fecha;

	private Integer horario;

	private Boolean estado;

}
