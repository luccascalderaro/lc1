package com.luccascalderaro.lc1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.Paciente;
import com.luccascalderaro.lc1.repositories.PacienteRepository;
import com.luccascalderaro.lc1.service.exceptions.DataIntegrityException;
import com.luccascalderaro.lc1.service.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repo;
	
	
	public Paciente find(Integer id) {
		Optional<Paciente> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Paciente nao encontrado, ID:" + id));
	}

	
	public List<Paciente> findAll() {

		return repo.findAll();

	}
	
	public void delete(Integer id) {
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possivel deletar o Paciente");
			
		}
	}
	
	public Paciente insert(Paciente obj) {
		obj.setId(null);
		
		return repo.save(obj);
	}
	
	
	public Paciente update(Integer id, Paciente obj) {
		
		Paciente p = obj;
		
		p.setId(id);
		
		return repo.save(p);
	}

}
