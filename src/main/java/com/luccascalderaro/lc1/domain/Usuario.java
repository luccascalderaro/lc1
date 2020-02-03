package com.luccascalderaro.lc1.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.luccascalderaro.lc1.domain.enums.Perfil;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (unique = true)
	@NotNull
	private String login;
	
	@NotNull
	private String senha;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	@CollectionTable(name = "PERFIL")
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Integer> perfilList = new HashSet<>();


	public Usuario () {
		addPerfil(Perfil.CLIENTE);
		
	}


	public Usuario(Integer id, @NotNull String login, @NotNull String senha, @NotNull String email) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.email = email;
		addPerfil(Perfil.CLIENTE);
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	

	public Set<Perfil> getPerfilList(){
		return perfilList.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
		
	}

	public void addPerfil(Perfil cod) {
		perfilList.add(cod.getCod());
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
