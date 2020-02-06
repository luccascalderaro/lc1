package com.luccascalderaro.lc1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.Agenda;
import com.luccascalderaro.lc1.repositories.AgendaRepository;
import com.luccascalderaro.lc1.service.exceptions.ObjectNotFoundException;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository repo;

	public Agenda insert(Agenda obj) {

		obj.setId(null);

		return repo.save(obj);

	}

	public List<Agenda> findAll() {

		return repo.findAll();
	}

	public Agenda find(Integer id) {

		Optional<Agenda> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Agenda nao encontrada"));
	}
	
	public void delete(Integer id) {
		try {
		repo.deleteById(id);
		}
		catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("Não foi possivel deletar a agenda");
			
		}
		
	}
	
}
