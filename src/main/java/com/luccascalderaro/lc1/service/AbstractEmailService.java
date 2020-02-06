package com.luccascalderaro.lc1.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.luccascalderaro.lc1.domain.Agendamento;

public abstract class AbstractEmailService implements EmailService {

	@Override
	public void enviarConfirmacaoAgendamento(Agendamento obj) {
		// TODO Auto-generated method stub

	}
	
	
	public SimpleMailMessage prepararEmailAgendamento(Agendamento obj) {
	//	SimpleMailMessage sm = new SimpleMailMessage();
		
		
		
		return null;
		
	}

	@Override
	public void enviarConfirmacaoAgendamentoHtml(Agendamento obj) {
		// TODO Auto-generated method stub

	}
	
	public MimeMessage prepararEmailAgendamentoHtml(Agendamento obj) {
		
		return null;
	}

}
