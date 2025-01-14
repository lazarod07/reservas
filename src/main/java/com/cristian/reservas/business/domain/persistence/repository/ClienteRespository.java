package com.cristian.reservas.business.domain.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristian.reservas.business.domain.persistence.entity.Cliente;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente, Integer> {

}
