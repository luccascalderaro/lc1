package com.luccascalderaro.lc1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luccascalderaro.lc1.domain.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

}
