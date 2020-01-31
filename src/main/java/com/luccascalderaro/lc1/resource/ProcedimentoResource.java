package com.luccascalderaro.lc1.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luccascalderaro.lc1.domain.Procedimento;
import com.luccascalderaro.lc1.service.ProcedimentoService;

@RestController
@RequestMapping(value = "/procedimentos")
public class ProcedimentoResource {

	@Autowired
	private ProcedimentoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Procedimento> find(@PathVariable Integer id) {

		Procedimento obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Procedimento> insert(@Valid @RequestBody Procedimento obj){
		
		 obj = service.insert(obj);
		 
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getNome()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
