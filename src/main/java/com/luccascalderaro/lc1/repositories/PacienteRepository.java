package com.luccascalderaro.lc1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luccascalderaro.lc1.domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
