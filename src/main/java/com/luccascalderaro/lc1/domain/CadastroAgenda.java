package com.luccascalderaro.lc1.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.luccascalderaro.lc1.domain.enums.StatusCadastroAgenda;

@Entity
public class CadastroAgenda {
	
	@Id
	private Integer id;
	
	
	@NotNull
	private StatusCadastroAgenda status;
	
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
	

}
