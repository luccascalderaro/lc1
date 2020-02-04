package com.luccascalderaro.lc1.dto;

import java.io.Serializable;

public class MedicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String nome;
	
	private String email;
	
	private String especialidade;
	
	private String subEspecialidade;
	
	
	public MedicoDTO() {
		
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getSubEspecialidade() {
		return subEspecialidade;
	}

	public void setSubEspecialidade(String subEspecialidade) {
		this.subEspecialidade = subEspecialidade;
	}
	
	
	

}
