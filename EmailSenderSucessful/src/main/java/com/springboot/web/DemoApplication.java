package com.springboot.web;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.springboot.web.service.EmailSenderService;

// this mail sender is working properly 
@SpringBootApplication
public class DemoApplication {
	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		service.sendEmailWithAttachment("keshavkoli191@gmail.com", "This is Email Body with Attachment...",
				"This email has attachment", "C:\\Users\\91774\\Desktop\\jai.jpg");

		service.sendEmailWithAttachment("keshavkoli191@gmail.com", "djsfkhjs", "dsjfkhkdj", "jdhfkjhkhf");
	}
}
