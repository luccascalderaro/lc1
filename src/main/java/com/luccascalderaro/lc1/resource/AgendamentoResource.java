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

import com.luccascalderaro.lc1.domain.Agendamento;
import com.luccascalderaro.lc1.service.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoResource {

	@Autowired
	private AgendamentoService service;

	@GetMapping
	private ResponseEntity<List<Agendamento>> findAll() {

		List<Agendamento> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	private ResponseEntity<Void> insert(@Valid @RequestBody Agendamento obj) {

		obj.setId(null);
		
		service.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		

		return ResponseEntity.created(uri).build();
	}

}
