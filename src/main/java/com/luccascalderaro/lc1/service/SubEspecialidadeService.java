package com.luccascalderaro.lc1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.SubEspecialidade;
import com.luccascalderaro.lc1.repositories.SubEspecialidadeRepository;
import com.luccascalderaro.lc1.service.exceptions.DataIntegrityException;
import com.luccascalderaro.lc1.service.exceptions.ObjectNotFoundException;

@Service
public class SubEspecialidadeService {

	@Autowired
	private SubEspecialidadeRepository repo;

	public SubEspecialidade find(Integer id) {

		Optional<SubEspecialidade> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"SubEspecialidade não encontrada, ID: " + id + " , Tipo: " + SubEspecialidade.class.getName()));

	}

	public SubEspecialidade insert(SubEspecialidade obj) {

		obj.setId(null);

		return repo.save(obj);
	}

	public void updateData(SubEspecialidade newObj, SubEspecialidade obj) {

		newObj.setNome(obj.getNome());
	}
	
	public SubEspecialidade update(SubEspecialidade obj) {
		
		SubEspecialidade newObj = find(obj.getId());
		
		updateData(newObj, obj);
		
		return repo.save(newObj);
		
	}
	
	public void delete(Integer id) {
		
		 find(id);
		try {
		repo.deleteById(id);
		}
		
		catch(ObjectNotFoundException e) {
			throw new DataIntegrityException("Nao foi possivel excluir essa SubEspecialidade");
		}
		
	}
	
}
