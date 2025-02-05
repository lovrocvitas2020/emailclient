package com.example.sendemailclient.emailclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailclientApplication {

	@Autowired
	private EmailSenderService service;
	public static void main(String[] args) {
        SpringApplication.run(EmailclientApplication.class, args);
    }

    // This method will trigger when the application is fully started
    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() {
        service.sendSimpleEmail(
		"lcvitas@gmail.com",
		 "Test Subject", 
		 "Hello, this is a test email!");
    }

}
