package com.java.mailcsv.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java.mailcsv.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-csv")
    public String sendEmailsFromCSV(
        @RequestParam("file") MultipartFile file,
        @RequestParam String subject,
        @RequestParam String text) {

        try {
            emailService.sendEmailsFromCSV(file, subject, text);
            return "Emails sent successfully!";
        } catch (IOException | MessagingException e) {
            return "Error sending emails: " + e.getMessage();
        }
    }
}
