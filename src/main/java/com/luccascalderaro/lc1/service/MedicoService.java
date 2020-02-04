package com.luccascalderaro.lc1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.Especialidade;
import com.luccascalderaro.lc1.domain.Medico;
import com.luccascalderaro.lc1.domain.SubEspecialidade;
import com.luccascalderaro.lc1.dto.MedicoDTO;
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
		catch (DataIntegrityViolationException e) {
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
	
	
	public Medico fromDTO(MedicoDTO dto) {
		
		Medico obj = new Medico(null, dto.getNome(), dto.getEmail(), null, null);
		
		Especialidade esp =  new Especialidade(null, dto.getEspecialidade());
		
		SubEspecialidade sub = new SubEspecialidade(null, dto.getSubEspecialidade(), esp);
		
		List<SubEspecialidade> listsub = new ArrayList<>();
		
		listsub.add(sub);
		
		obj.setSubEspecialidade(listsub);
		
		return obj;
		
	}
	

}
