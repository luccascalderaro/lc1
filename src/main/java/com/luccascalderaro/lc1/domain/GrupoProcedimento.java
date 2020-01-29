package com.luccascalderaro.lc1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class GrupoProcedimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeGrupoProcedimento;
	
	@JsonIgnore
	@OneToMany(mappedBy = "grupoProcedimento")
	private List<Procedimento> procedimentos = new ArrayList<>();
	
	public GrupoProcedimento() {
		
	}

	

	public GrupoProcedimento(Integer id, String nomeGrupoProcedimento) {
		super();
		this.id = id;
		this.nomeGrupoProcedimento = nomeGrupoProcedimento;
	}



	public String getNomeGrupoProcedimento() {
		return nomeGrupoProcedimento;
	}

	public void setNomeGrupoProcedimento(String nomeGrupoProcedimento) {
		this.nomeGrupoProcedimento = nomeGrupoProcedimento;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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
		GrupoProcedimento other = (GrupoProcedimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	

}
