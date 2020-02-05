package com.luccascalderaro.lc1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luccascalderaro.lc1.domain.CadastroAgenda;

@Repository
public interface CadastroAgendaRepository extends JpaRepository<CadastroAgenda, Integer> {

}
