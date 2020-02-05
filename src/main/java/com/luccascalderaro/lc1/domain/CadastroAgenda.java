package com.luccascalderaro.lc1.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.luccascalderaro.lc1.domain.enums.StatusCadastroAgenda;

@Entity
public class CadastroAgenda implements Serializable{
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@NotNull
	private StatusCadastroAgenda status;
	
	
	private List<Agenda> agendas;
	
	public CadastroAgenda() {
		this.status = StatusCadastroAgenda.ATIVO;
	}
	
	
	public CadastroAgenda(Integer id, @NotNull Integer status) {
		super();
		this.id = id;
		this.status = StatusCadastroAgenda.ATIVO;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public StatusCadastroAgenda getStatus() {
		return status;
	}


	public void setStatus(StatusCadastroAgenda status) {
		this.status = status;
	}


	public List<Agenda> getAgendas() {
		return agendas;
	}


	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}
	
	
	

}
