package com.luccascalderaro.lc1.resource;

import java.net.URI;
import java.util.List;

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

import com.luccascalderaro.lc1.domain.PrestadorEndereco;
import com.luccascalderaro.lc1.service.PrestadorEnderecoService;

@RequestMapping(value="/prestadorEndereco")
@RestController
public class PrestadorEnderecoResource {
	
	@Autowired
	private PrestadorEnderecoService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<PrestadorEndereco> find(@PathVariable Integer id){
		PrestadorEndereco obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@GetMapping
	public ResponseEntity<List<PrestadorEndereco>> findAll(){
		List<PrestadorEndereco> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody PrestadorEndereco obj) {
		service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody PrestadorEndereco obj, @PathVariable Integer id){
		obj.setId(id);
		service.update(obj);
		
		return ResponseEntity.noContent().build();
		
	}

}
