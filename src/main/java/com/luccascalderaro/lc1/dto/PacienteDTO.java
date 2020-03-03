package com.luccascalderaro.lc1.dto;

import java.io.Serializable;

public class PacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String telefone1;
	
	private String telefone2;
	
	private String telefone3;
	
	private String endereco;
	
	private String nascimento;
	
	private String email;
	
	
	public PacienteDTO() {
		
	}


	public PacienteDTO(String nome, String telefone1, String telefone2, String telefone3, String endereco,
			String nascimento, String email) {
		super();
		this.nome = nome;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.telefone3 = telefone3;
		this.endereco = endereco;
		this.nascimento = nascimento;
		this.email = email;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone1() {
		return telefone1;
	}


	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}


	public String getTelefone2() {
		return telefone2;
	}


	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}


	public String getTelefone3() {
		return telefone3;
	}


	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getNascimento() {
		return nascimento;
	}


	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
}
