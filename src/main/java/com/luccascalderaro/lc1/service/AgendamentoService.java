package com.luccascalderaro.lc1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.Agendamento;
import com.luccascalderaro.lc1.repositories.AgendamentoRepository;
import com.luccascalderaro.lc1.service.exceptions.ObjectNotFoundException;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository repo;
	
	@Autowired
	private SubEspecialidadeService subEspServe;
	
	@Autowired
	private AgendaService agendaService;
	
	@Autowired
	private PacienteService pacService;
	
	
	@Autowired
	private EmailService email;
	
	public List<Agendamento> findAll(){
		
		return repo.findAll();
	}
	
	public Agendamento find(Integer id) {
		Optional<Agendamento> obj = repo.findById(id);
		
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Agendamento nao encontrado"));
		
	}
	
	@Transactional
	public Agendamento insert(Agendamento obj) {
		obj.setId(null);
		
		
		
		obj = repo.save(obj);
		
		System.out.println("ID:::::::" + obj.getId());
		System.out.println("SUB:::::::" + obj.getPaciente().getId());
		
		obj.setSubespecialidade(subEspServe.find(obj.getSubespecialidade().getId()));
		obj.setPaciente(pacService.find(obj.getPaciente().getId()));
		obj.setAgenda(agendaService.find(obj.getAgenda().getId()));
		
		 email.enviarConfirmacaoAgendamento(obj);
		 
		 
		
		return obj;
		 
		
	}

}
