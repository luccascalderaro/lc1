package com.luccascalderaro.lc1.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;

import com.luccascalderaro.lc1.domain.Agendamento;



public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;
	
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private TemplateEngine templaEngine;

	@Override
	public void enviarConfirmacaoAgendamento(Agendamento obj) {
		// TODO Auto-generated method stub

	}
	
	
	public SimpleMailMessage prepararEmailAgendamento(Agendamento obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(Agendamento.emailPaciente(obj.getPaciente()));
		sm.setFrom(sender);
		sm.setSubject("Confirmação de Agendamento");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
		
	}
	

	@Override
	public void enviarConfirmacaoAgendamentoHtml(Agendamento obj) {
		

	}
	
	public MimeMessage prepararEmailAgendamentoHtml(Agendamento obj) throws MessagingException {
		
		MimeMessage mime = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mime, true);
		mmh.setTo(Agendamento.emailPaciente(obj.getPaciente()));
		mmh.setFrom(sender);
		mmh.setSubject("Confirmação de Agendamento");
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(obj.toString());
		
		return mime;
		
	}

}
