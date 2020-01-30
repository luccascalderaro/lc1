package com.luccascalderaro.lc1.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.Especialidade;
import com.luccascalderaro.lc1.domain.GrupoProcedimento;
import com.luccascalderaro.lc1.domain.Procedimento;
import com.luccascalderaro.lc1.domain.SubEspecialidade;
import com.luccascalderaro.lc1.repositories.EspecialidadeRepository;
import com.luccascalderaro.lc1.repositories.GrupoProcedimentoRepository;
import com.luccascalderaro.lc1.repositories.ProcedimentoRepository;
import com.luccascalderaro.lc1.repositories.SubEspecialidadeRepository;

@Service
public class DBService {

	@Autowired
	private ProcedimentoRepository procedimentoRepository;

	@Autowired
	private GrupoProcedimentoRepository grupoProcedimentoRepository;
	
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	@Autowired
	private SubEspecialidadeRepository subEspecialidadeRepository;
	
	

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
		
		Especialidade esp1 = new Especialidade(null, "Cardiologia");
		
		Especialidade esp2 = new Especialidade(null, "Ortopedia");
		
		
		SubEspecialidade sub1 = new SubEspecialidade(null, "Sub1-C.", esp1);
		
		SubEspecialidade sub2 =  new SubEspecialidade(null, "Sub2-C", esp1);
		
		SubEspecialidade sub3 = new SubEspecialidade(null, "Sub1-O", esp2);
		
		SubEspecialidade sub4 = new SubEspecialidade(null, "Sub2-O", esp2);
		
		SubEspecialidade sub5 = new SubEspecialidade(null, "Sub3-O", esp2);
		
		esp1.getSubEspecialidade().addAll(Arrays.asList(sub1,sub2));
		
		esp2.getSubEspecialidade().addAll(Arrays.asList(sub3,sub4,sub5));
		
		
		
		especialidadeRepository.saveAll(Arrays.asList(esp1,esp2));
		
		subEspecialidadeRepository.saveAll(Arrays.asList(sub1,sub2,sub3,sub4,sub5));
	
		
		
		

	}

}
