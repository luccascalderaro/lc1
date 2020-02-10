package com.luccascalderaro.lc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.Usuario;
import com.luccascalderaro.lc1.domain.enums.Perfil;
import com.luccascalderaro.lc1.repositories.UsuarioRepository;
import com.luccascalderaro.lc1.security.UserSS;
import com.luccascalderaro.lc1.service.exceptions.AuthorizationException;
import com.luccascalderaro.lc1.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UsuarioRepository repo;
	
	
	public Usuario findByEmail(String email) {
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}
		Usuario obj = repo.findByEmail(email);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto nao encontrado! ID: " + user.getId()
				+ ", Tipo: " + Usuario.class.getName());
		}
		return obj;
	}
	
	public List<Usuario> findAll(){
		
		return repo.findAll();
		
	}
	
	

}
