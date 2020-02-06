package com.luccascalderaro.lc1.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luccascalderaro.lc1.domain.CadastroAgenda;
import com.luccascalderaro.lc1.service.CadastroAgendaService;

@RequestMapping("/cadastroAgenda")
@RestController
public class CadastroAgendaResource {
	
	@Autowired
	private CadastroAgendaService service;
	

	@PostMapping()
	public ResponseEntity<Void> insert(@Valid @RequestBody CadastroAgenda obj) {
		
		service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	
	}

	@GetMapping
	public ResponseEntity<List<CadastroAgenda>> findAll() {

		List<CadastroAgenda> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	

}
