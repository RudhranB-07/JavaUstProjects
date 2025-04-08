package com.java.mail.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.mail.dto.EmailRequest;
import com.java.mail.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;
    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    
    @GetMapping("/home")
    public String home() {
    	return "welcome";
    }

    @PostMapping("/send")
    public String sendMail(@RequestBody EmailRequest request) {
        try {
            emailService.sendEmail(request.getTo(), request.getSubject(), request.getText());
            return "Email sent successfully!";
        } catch (MessagingException e) {
            logger.error("Error sending email: {}", e.getMessage(), e);
            return "Error sending email: " + e.getMessage();
        }
    }
}
