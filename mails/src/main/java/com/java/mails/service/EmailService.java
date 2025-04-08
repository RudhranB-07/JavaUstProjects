package com.java.mails.service;


import java.util.List;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // Method to send email to multiple recipients
    public void sendEmail(List<String> toList, String subject, String text) throws MessagingException {
        for (String to : toList) {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);  // Set individual recipient
            helper.setSubject(subject);
            helper.setText(text);  // true for HTML content

            mailSender.send(message);  // Send the email
        }
    }
}
