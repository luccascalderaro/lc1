package com.luccascalderaro.lc1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.GrupoProcedimento;
import com.luccascalderaro.lc1.repositories.GrupoProcedimentoRepository;
import com.luccascalderaro.lc1.service.exceptions.DataIntegrityException;
import com.luccascalderaro.lc1.service.exceptions.ObjectNotFoundException;

@Service
public class GrupoProcedimentoService {

	@Autowired
	private GrupoProcedimentoRepository repo;

	public GrupoProcedimento find(Integer id) {
		Optional<GrupoProcedimento> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Grupo Procedimento nao encontrado"));

	}

	public void updateData(GrupoProcedimento newObj, GrupoProcedimento obj) {
		newObj.setNomeGrupoProcedimento(obj.getNomeGrupoProcedimento());
	}

	public GrupoProcedimento update(GrupoProcedimento obj) {
		GrupoProcedimento newObj = find(obj.getId());

		updateData(newObj, obj);

		return repo.save(newObj);

	}

	public GrupoProcedimento insert(GrupoProcedimento obj) {
		obj.setId(null);
		return repo.save(obj);

	}
	
	public void delete(Integer id) {
		try {
		find(id);
		repo.deleteById(id);
		}
		
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Nao foi possivel deletar o Grupo de Procedimento");
			// TODO: handle exception
		}
		
	}
	
	public List<GrupoProcedimento> findAll(){
		return repo.findAll();
	}
	
	

}
