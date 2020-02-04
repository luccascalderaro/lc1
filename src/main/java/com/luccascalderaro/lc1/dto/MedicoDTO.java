package com.luccascalderaro.lc1.dto;

import java.io.Serializable;
import java.util.List;

import com.luccascalderaro.lc1.domain.Especialidade;
import com.luccascalderaro.lc1.domain.Medico;
import com.luccascalderaro.lc1.domain.SubEspecialidade;

public class MedicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;

	private String email;

	private String especialidade;

	private String subEspecialidade;

	public MedicoDTO(Medico obj, List<SubEspecialidade> listSub, List<Especialidade> listEsp) {

		nome = obj.getNome();
		email = obj.getEmail();
		subEspecialidade = obj.getSubEspecialidade().toString();
		especialidade = getNomeEspecialidade(obj, listSub, listEsp);

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

	public String getNomeEspecialidade(Medico obj, List<SubEspecialidade> listSub, List<Especialidade> listEsp) {

		String nome = null;

		for (SubEspecialidade subEsp : obj.getSubEspecialidade()) {
			for (SubEspecialidade subEsp2 : listSub) {
				if (subEsp.equals(subEsp2)) {
					SubEspecialidade sub_ok = subEsp;
					for (Especialidade esp : listEsp) {
						if (sub_ok.getEspecialidade().equals(esp)) {
							nome = nome + esp.getNome() + ", ";

						}

					}

				}
			}
		}
		return nome.substring(4, nome.length() - 2);

	}

}
