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

import com.luccascalderaro.lc1.domain.GrupoProcedimento;
import com.luccascalderaro.lc1.service.GrupoProcedimentoService;

@RestController
@RequestMapping(value = "/grupoProcedimentos")
public class GrupoProcedimentoResource {

	@Autowired
	private GrupoProcedimentoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<GrupoProcedimento> find(@PathVariable Integer id) {

		GrupoProcedimento obj = service.find(id);

		return ResponseEntity.ok().body(obj);

	}

	@PostMapping
	private ResponseEntity<Void> insert(@Valid @RequestBody GrupoProcedimento obj) {
		obj = service.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody GrupoProcedimento obj, @PathVariable Integer id) {

		obj.setId(id);

		obj = service.update(obj);

		return ResponseEntity.noContent().build();

	}

	@GetMapping
	public ResponseEntity<List<GrupoProcedimento>> findAll() {
		List<GrupoProcedimento> list = service.findAll();

		return ResponseEntity.ok().body(list);

	}

}
