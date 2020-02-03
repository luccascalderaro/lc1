package com.luccascalderaro.lc1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Medico implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String nome;
	
	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefone = new HashSet<>();
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String crm;
	
	@NotNull
	private String endereco;
	
	
	@ManyToMany
	@JoinTable(name = "MEDICO_SUBESPECIALIDADE",
		joinColumns = @JoinColumn(name = "medico_id"),
		inverseJoinColumns = @JoinColumn (name = "subespecialidade_id")
	
	)
	private List<SubEspecialidade> subEspecialidade = new ArrayList<>();
	
	
	public Medico () {
		
	}


	public Medico(Integer id, @NotNull String nome, @NotNull @Email String email, @NotNull String crm,
			@NotNull String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.crm = crm;
		this.endereco = endereco;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Set<String> getTelefone() {
		return telefone;
	}


	public void setTelefone(Set<String> telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCrm() {
		return crm;
	}


	public void setCrm(String crm) {
		this.crm = crm;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<SubEspecialidade> getSubEspecialidade() {
		return subEspecialidade;
	}


	public void setSubEspecialidade(List<SubEspecialidade> subEspecialidade) {
		this.subEspecialidade = subEspecialidade;
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
		Medico other = (Medico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
