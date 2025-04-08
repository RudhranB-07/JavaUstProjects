package com.java.mailcsv.service;

import java.io.IOException;
import java.util.List;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private final CSVReaderService csvReaderService;

    public EmailService(JavaMailSender mailSender, CSVReaderService csvReaderService) {
        this.mailSender = mailSender;
        this.csvReaderService = csvReaderService;
    }

    public void sendEmailsFromCSV(MultipartFile file, String subject, String text) throws IOException, MessagingException {
        List<String> emails = csvReaderService.readEmailsFromCSV(file);
        for (String email : emails) {
            sendEmail(email, subject, text);
        }
    }

    private void sendEmail(String to, String subject, String text) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);

        mailSender.send(message);
    }
}
