package com.luccascalderaro.lc1.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luccascalderaro.lc1.domain.enums.StatusAgendamento;

@Entity
public class Agendamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "agenda_id")
	@MapsId
	private Agenda agenda;

	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "subespecialidade_id")
	private SubEspecialidade subespecialidade;

	private StatusAgendamento statusAgendamento;

	public Agendamento() {

	}
	

	public Agendamento(Integer id, Agenda agenda, Paciente paciente, SubEspecialidade subespecialidade,
			StatusAgendamento statusAgendamento) {
		super();
		this.id = id;
		this.agenda = agenda;
		this.paciente = paciente;
		this.subespecialidade = subespecialidade;
		this.statusAgendamento = statusAgendamento;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public StatusAgendamento getStatusAgendamento() {
		return statusAgendamento;
	}

	public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}
	
	public static String emailPaciente(Paciente paciente) {
		return paciente.getEmail();
		
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
		Agendamento other = (Agendamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("O Agendamento do senhor(a) ");
		builder.append(paciente.getNome());
		builder.append(" para data ");
		builder.append(agenda.getData());
		builder.append(" no horario ");
		builder.append(agenda.getHorario());
		builder.append(" na especialidade ");
		builder.append(subespecialidade.getNome());
		builder.append(" foi realizado com sucesso. ");
		return builder.toString();
	}
	
	
	

}
