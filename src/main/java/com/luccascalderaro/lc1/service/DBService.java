package com.luccascalderaro.lc1.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.GrupoProcedimento;
import com.luccascalderaro.lc1.domain.Procedimento;
import com.luccascalderaro.lc1.repositories.GrupoProcedimentoRepository;
import com.luccascalderaro.lc1.repositories.ProcedimentoRepository;

@Service
public class DBService {

	@Autowired
	private ProcedimentoRepository procedimentoRepository;

	@Autowired
	private GrupoProcedimentoRepository grupoProcedimentoRepository;

	public void instantiateDatabase() throws ParseException {
		
		GrupoProcedimento grup1 = new GrupoProcedimento(null, "Grupo 1");
		GrupoProcedimento grup2 = new GrupoProcedimento(null, "Grupo 2");
		
		Procedimento proc1 = new Procedimento(null, "Procedimento 1", grup1);
		
		Procedimento proc2 = new Procedimento(null, "Procedimento 2", grup1);
		
		Procedimento proc3 = new Procedimento(null, "Procedimento 3", grup2);
		
		grup1.getProcedimentos().addAll(Arrays.asList(proc1,proc2));
		grup2.getProcedimentos().addAll(Arrays.asList(proc3));
		
		grupoProcedimentoRepository.saveAll(Arrays.asList(grup1,grup2));
		procedimentoRepository.saveAll(Arrays.asList(proc1,proc2,proc3));
		
		

	}

}
