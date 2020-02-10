package com.luccascalderaro.lc1.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luccascalderaro.lc1.domain.Usuario;
import com.luccascalderaro.lc1.service.UsuarioService;

@RequestMapping("/usuario")
@RestController
public class UsuarioResource {
	
	@Autowired
	private UsuarioService servico;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = servico.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}

}
