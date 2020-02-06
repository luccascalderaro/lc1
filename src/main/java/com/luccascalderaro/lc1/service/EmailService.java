package com.luccascalderaro.lc1.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.luccascalderaro.lc1.domain.Agendamento;

public interface EmailService {
	
	void enviarConfirmacaoAgendamento(Agendamento ag);
	
	void enviarEmail(SimpleMailMessage msg);
	
	void enviarConfirmacaoAgendamentoHtml(Agendamento obj);
	
	void enviarEmailHtml(MimeMessage msg);

}
