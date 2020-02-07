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
import org.thymeleaf.context.Context;

import com.luccascalderaro.lc1.domain.Agendamento;



public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;
	
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private TemplateEngine templateEngine;

	@Override
	public void enviarConfirmacaoAgendamento(Agendamento obj) {
		
		SimpleMailMessage sm = prepararEmailAgendamento(obj);
		enviarEmail(sm);

	}
	
	
	public SimpleMailMessage prepararEmailAgendamento(Agendamento obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getPaciente().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Confirmação de Agendamento");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
		
	}
	

	@Override
	public void enviarConfirmacaoAgendamentoHtml(Agendamento obj) {
		try {
			MimeMessage mm = prepararEmailAgendamentoHtml(obj);
			enviarEmailHtml(mm);
			}
			catch(MessagingException e) {
				enviarConfirmacaoAgendamento(obj);
			}

	}
	
	
	protected String htmlFromTemplateAgendamento(Agendamento obj) {
		Context context = new Context();
		context.setVariable("agendamento", obj);
		return templateEngine.process("email/confirmacaoAgendamento", context);
		
	}
	
	public MimeMessage prepararEmailAgendamentoHtml(Agendamento obj) throws MessagingException {
		
		MimeMessage mime = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mime, true);
		mmh.setTo(obj.getPaciente().getEmail());
		mmh.setFrom(sender);
		mmh.setSubject("Confirmação de Agendamento");
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplateAgendamento(obj),true);
		
		return mime;
		
	}

}
