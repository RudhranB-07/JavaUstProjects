package com.java.mails.dto;


import java.util.List;

public class EmailRequest {

    private List<String> toList;  // List of email addresses
    private String subject;
    private String text;

    // Getters and Setters
    public List<String> getToList() {
        return toList;
    }

    public void setToList(List<String> toList) {
        this.toList = toList;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
