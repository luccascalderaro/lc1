package com.luccascalderaro.lc1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.Especialidade;
import com.luccascalderaro.lc1.repositories.EspecialidadeRepository;
import com.luccascalderaro.lc1.service.exceptions.DataIntegrityException;
import com.luccascalderaro.lc1.service.exceptions.ObjectNotFoundException;

@Service
public class EspecialidadeService {

	@Autowired
	private EspecialidadeRepository repo;

	public Especialidade find(Integer id) {
		Optional<Especialidade> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado: " + id + ", Tipo: " + Especialidade.class.getName()));

	}

	public Especialidade insert(Especialidade obj) {
		obj.setId(null);

		return repo.save(obj);

	}

	public void updateData(Especialidade newObj, Especialidade obj) {

		newObj.setNome(obj.getNome());
	}

	public Especialidade update(Especialidade obj) {

		Especialidade newObj = find(obj.getId());
		updateData(newObj, obj);

		return repo.save(newObj);
	}

	public void delete(Integer id) {
		try {
			find(id);
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possivel deletar a especialidade pois ela ainda tem vinculos");
		}

	}
	
	public List<Especialidade> findAll(){
		
		return repo.findAll();
		
	}

}
