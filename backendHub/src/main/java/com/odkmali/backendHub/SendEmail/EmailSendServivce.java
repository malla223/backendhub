package com.odkmali.backendHub.SendEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendServivce {

  @Autowired
    private JavaMailSender javaMailSender;

    public void envoyerEmail (String toEmail, String body, String subject){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("hubscolaire@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        javaMailSender.send(message);
    }
}
