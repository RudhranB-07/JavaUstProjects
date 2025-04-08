package com.java.mails.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.mails.dto.EmailRequest;
import com.java.mails.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/email")
public class EmailController{

    private final EmailService emailService;
    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);


    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    
    @GetMapping("/home")
    public String home() {
    	return "welcome";
    }

    // Endpoint to send email to multiple recipients
    
//    {
//    	  "toList": ["recipient1@example.com", "recipient2@example.com", "recipient3@example.com"],
//    	  "subject": "Test Email Subject",
//    	  "text": "Hello Team!!!"
//    }

    
    @PostMapping("/send")
    public String sendMail(@RequestBody EmailRequest request) {
        try {
            emailService.sendEmail(request.getToList(), request.getSubject(), request.getText());
            return "Email sent successfully!";
        } catch (MessagingException e) {
            return "Error sending email: " + e.getMessage();
        }
    }
}
