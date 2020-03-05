package com.luccascalderaro.lc1.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.Paciente;
import com.luccascalderaro.lc1.dto.PacienteDTO;
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
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possivel deletar o Paciente");

		}
	}

	public Paciente insert(PacienteDTO dto) {

		Paciente paciente = fromDto(dto);

		return repo.save(paciente);
	}

	public Paciente update(Integer id, PacienteDTO obj) {

		Paciente p = fromDto(obj);

		p.setId(id);

		return repo.save(p);
	}

	public Paciente findByEmail(String email) {
		Paciente pa = this.repo.findByEmail(email);

		return pa;
	}

	public Paciente fromDto(PacienteDTO dto) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date data;
		try {
			data = sdf.parse(dto.getNascimento());
			Paciente paciente = new Paciente(null, dto.getNome(), dto.getEndereco(), data, dto.getEmail());
			
			paciente.getTelefone().addAll(Arrays.asList(dto.getTelefone1(),dto.getTelefone2(),dto.getTelefone3()));

			return paciente;
		} catch (ParseException e) {
			System.out.println("Data de nascimento no formato errado");
			return null;
		}

	}
	
	public PacienteDTO toDto(Paciente paciente) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data = sdf.format(paciente.getNascimento());
		
		PacienteDTO dto = new PacienteDTO(paciente.getNome(), paciente.getTelefone().get(0),null, null,
				paciente.getEndereco(), data , paciente.getEmail(),paciente.getId().toString());
		
		return dto;
		
	}

}
