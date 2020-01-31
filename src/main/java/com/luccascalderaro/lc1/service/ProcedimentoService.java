package com.luccascalderaro.lc1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.Procedimento;
import com.luccascalderaro.lc1.repositories.ProcedimentoRepository;
import com.luccascalderaro.lc1.service.exceptions.ObjectNotFoundException;

@Service
public class ProcedimentoService {

	@Autowired
	private ProcedimentoRepository repo;

	public Procedimento find(Integer id) {
		Optional<Procedimento> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Procedimento nao encontrado"));
	}

	public Procedimento insert(Procedimento obj) {
		
		obj.setId(null);

		return repo.save(obj);

	}

	public void updateData(Procedimento newobj, Procedimento obj) {

		newobj.setNome(obj.getNome());
	}

	public Procedimento update(Procedimento obj) {
		Procedimento newobj = find(obj.getId());

		updateData(newobj, obj);
		return repo.save(newobj);

	}

	public void delete(Integer id) {
		try {
		find(id);
		
		repo.deleteById(id);
	
	}
		catch(DataIntegrityViolationException e) {
			new DataIntegrityViolationException("Nao foi possivel excluir o Procedimento");
		}
	}

}
