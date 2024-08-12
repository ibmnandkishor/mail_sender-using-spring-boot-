package com.mail_sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MailSenderApplication {

    @Autowired
    private EmailSenderService senderService;

    public static void main(String[] args) {
        SpringApplication.run(MailSenderApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail() {
        String toEmail = "rtanver30@gmail.com";
        String subject = "This is the subject";
        String body = "hi how are you rohit";

        senderService.sendEmail(toEmail, subject, body);
    }
}
