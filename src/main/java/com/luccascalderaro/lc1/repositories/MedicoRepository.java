package com.luccascalderaro.lc1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luccascalderaro.lc1.domain.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
