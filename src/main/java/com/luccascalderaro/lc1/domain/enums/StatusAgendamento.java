package com.luccascalderaro.lc1.domain.enums;

public enum StatusAgendamento {
	
	ATIVO(1,"ATIVO"),
	CANCELADO(2,"CANCELADO"),
	CONFIRMOU(3,"CONFIRMOU"),
	FALTOU(4,"FALTOU");
	
	private StatusAgendamento(Integer id, String status) {
		this.id = id;
		this.status = status;
	}


	private Integer id;
	
	private String status;


	public Integer getId() {
		return id;
	}


	public String getStatus() {
		return status;
	}


}
