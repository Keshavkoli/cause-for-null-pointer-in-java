package com.springboot.web.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
// check the properties file to get the password that has been stored from the mail
@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailSender;

	public void sendSimpleEmail(String toEmail, String body, String subject) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("keshavkoli191@gmail.com");// this is the one which i will send email
		message.setTo("keshavkoli191@gmail.com");
		message.setText("Jai Hanuman");
		message.setSubject(subject);

		mailSender.send(message);
		System.out.println("Mail Send...");
	}

	public void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment)
			throws MessagingException {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

		mimeMessageHelper.setFrom("keshavkoli191@gmail.com");
		mimeMessageHelper.setTo("keshavkoli191@gmail.com");
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);

		FileSystemResource fileSystem = new FileSystemResource(new File(attachment));
		System.out.println("EmailSenderService.sendEmailWithAttachment(:fileSystem:==>)"+fileSystem);
		mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);

		mailSender.send(mimeMessage);
		System.out.println("Mail Send...");

	}
}
