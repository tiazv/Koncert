package com.koncert.ris.models;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImp implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public boolean sendMail(String recipient, String subject, String text) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("tia.zvajker@gmail.com");
            message.setTo(recipient);
            message.setSubject(subject);
            message.setText(text);
            javaMailSender.send(message);


            //return "Mail poslan uspešno.";
        } catch (Exception e) {
            //return "Napaka pri pošiljanju maila.";
            return false;
        }
        return true;




    }
}
