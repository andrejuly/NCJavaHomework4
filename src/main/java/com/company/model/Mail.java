package com.company.model;

public class Mail {
    private static String to;
    private String subject;
    private String text;

    public static String getTo() {
        return to;
    }

    public static void setTo(String to) {
        Mail.to = to;
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

