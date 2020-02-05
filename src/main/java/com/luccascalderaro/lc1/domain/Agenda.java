package com.luccascalderaro.lc1.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.luccascalderaro.lc1.domain.enums.StatusCadastroAgenda;

@Entity
public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Medico medico;
	
	private Date data;
	
	private Integer horario;
	
	private Integer tempoConsulta;
	
	private StatusCadastroAgenda status;
	
	private List<Agendamento> agendamento;
	
	
	public Agenda() {
		
	}
	


	public Agenda(Integer id, Medico medico, Date data, Integer horario, Integer tempoConsulta,
			StatusCadastroAgenda status) {
		super();
		this.id = id;
		this.medico = medico;
		this.data = data;
		this.horario = horario;
		this.tempoConsulta = tempoConsulta;
		this.status = status;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Integer getHorario() {
		return horario;
	}


	public void setHorario(Integer horario) {
		this.horario = horario;
	}


	public Integer getTempoConsulta() {
		return tempoConsulta;
	}


	public void setTempoConsulta(Integer tempoConsulta) {
		this.tempoConsulta = tempoConsulta;
	}


	public StatusCadastroAgenda getStatus() {
		return status;
	}


	public void setStatus(StatusCadastroAgenda status) {
		this.status = status;
	}
	
	

	public List<Agendamento> getAgendamento() {
		return agendamento;
	}




	public void setAgendamento(List<Agendamento> agendamento) {
		this.agendamento = agendamento;
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
		Agenda other = (Agenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	

}
