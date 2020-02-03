package com.luccascalderaro.lc1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.Medico;
import com.luccascalderaro.lc1.repositories.MedicoRepository;
import com.luccascalderaro.lc1.service.exceptions.DataIntegrityException;
import com.luccascalderaro.lc1.service.exceptions.ObjectNotFoundException;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository repo;
	
	public Medico find(Integer id) {
		Optional<Medico> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Medico nao encontrado"));
		
	}
	
	
	public List<Medico> findAll(){
		List<Medico> list = repo.findAll();
		
		return list;
		
	}
	
	public Medico insert(Medico obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	
	public void delete(Integer id) {
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityException e) {
			throw new DataIntegrityException("Nao foi possivel deletar o medico");
			
		}
	}
	
	public void updateAux(Medico newObj, Medico obj) {
		newObj.setCrm(obj.getCrm());
		newObj.setEmail(obj.getEmail());
		newObj.setEndereco(obj.getEndereco());
		newObj.setNome(obj.getNome());
		newObj.setSubEspecialidade(obj.getSubEspecialidade());
		newObj.setTelefone(obj.getTelefone());
				
	}
	
	public Medico update(Medico obj) {
		Medico newObj = find(obj.getId());
		
		updateAux(newObj, obj);
		
		return repo.save(newObj);	
	}

}
