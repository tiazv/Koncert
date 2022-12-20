package com.koncert.ris.models;

public interface EmailService {

    boolean sendMail(String recipient, String subject, String text);
}
