package com.luccascalderaro.lc1.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luccascalderaro.lc1.domain.Paciente;
import com.luccascalderaro.lc1.dto.PacienteDTO;
import com.luccascalderaro.lc1.service.PacienteService;

@RequestMapping(value = "/paciente")
@RestController
public class PacienteResource {
	
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping
	public ResponseEntity<List<PacienteDTO>> findall(){
		
		List<Paciente> list = this.pacienteService.findAll();
		
		List<PacienteDTO> listDto = list.stream().map(x -> pacienteService.toDto(x)).collect(Collectors.toList());
		
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		this.pacienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Paciente> findById(@PathVariable Integer id){
		
		Paciente p = this.pacienteService.find(id);
		return ResponseEntity.ok().body(p);
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@Valid @RequestBody PacienteDTO pacienteDto){
		
		
		
		this.pacienteService.insert(pacienteDto);
		
		Paciente paciente = this.pacienteService.findByEmail(pacienteDto.getEmail());
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Paciente paciente, @PathVariable Integer id){
		
		this.pacienteService.update(id , paciente);
		
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	

}
