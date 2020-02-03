package com.luccascalderaro.lc1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.PrestadorEndereco;
import com.luccascalderaro.lc1.repositories.PrestadorEnderecoRepository;
import com.luccascalderaro.lc1.service.exceptions.DataIntegrityException;
import com.luccascalderaro.lc1.service.exceptions.ObjectNotFoundException;

@Service
public class PrestadorEnderecoService {

	@Autowired
	private PrestadorEnderecoRepository repo;

	public PrestadorEndereco find(Integer id) {
		Optional<PrestadorEndereco> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Endereco de Prestador nao encontrado"));

	}

	public List<PrestadorEndereco> findAll() {

		List<PrestadorEndereco> list = repo.findAll();

		return list;

	}

	public void delete(Integer id) {
		try {
			repo.deleteById(id);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException("Nao foi possivel deletar o endereco do prestador");
		}
	}

	public void updateAux(PrestadorEndereco newObj, PrestadorEndereco obj) {
		newObj.setNomeEnderecoPrestador(obj.getNomeEnderecoPrestador());
		newObj.setPrestador(obj.getPrestador());

	}

	public PrestadorEndereco update(PrestadorEndereco obj) {
		PrestadorEndereco newObj = find(obj.getId());
		updateAux(newObj, obj);

		return repo.save(newObj);

	}

	public PrestadorEndereco insert(PrestadorEndereco obj) {
		
		obj.setId(null);
		
		return repo.save(obj);

	}

}
