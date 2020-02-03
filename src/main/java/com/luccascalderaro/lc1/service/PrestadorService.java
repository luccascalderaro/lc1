package com.luccascalderaro.lc1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.Prestador;
import com.luccascalderaro.lc1.repositories.PrestadorRepository;
import com.luccascalderaro.lc1.service.exceptions.DataIntegrityException;
import com.luccascalderaro.lc1.service.exceptions.ObjectNotFoundException;

@Service
public class PrestadorService {

	@Autowired
	private PrestadorRepository repo;

	public Prestador find(Integer id) {
		Optional<Prestador> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Prestador nao encontrado, ID:" + id));
	}

	
	public List<Prestador> findAll() {

		return repo.findAll();

	}
	
	public void delete(Integer id) {
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityException e) {
			throw new DataIntegrityException("Não foi possivel deletar o Prestador");
			
		}
	}
	
	public Prestador insert(Prestador obj) {
		obj.setId(null);
		
		return repo.save(obj);
	}
	
	public void updateAux(Prestador newObj, Prestador obj) {
		newObj.setNomePrestador(obj.getNomePrestador());
		newObj.setCnpj(obj.getCnpj());
		newObj.setEnderecos(obj.getEnderecos());
		
		
	}
	
	public Prestador update(Prestador obj) {
		Prestador newObj = find(obj.getId());
		
		updateAux(newObj, obj);
		
		return repo.save(newObj);
	}
	

}
