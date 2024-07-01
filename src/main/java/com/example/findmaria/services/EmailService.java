package com.example.findmaria.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringEscapeUtils;

@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Value("${EMAIL_USERNAME}")
    private String EMAIL_USERNAME;

    public void sendMailTip(String name, String email, String tip, boolean anonymous) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("intelrequest@hallcounty.org");
        message.setSubject("New Tip Received");

        StringBuilder sb = new StringBuilder();
        if (!anonymous) {
            sb.append("Name: ").append(StringEscapeUtils.escapeHtml4(name)).append('\n');
            sb.append("Email: ").append(StringEscapeUtils.escapeHtml4(email)).append('\n');
        } else {
            sb.append("Anonymous Tip\n");
        }
        sb.append("Tip: ").append(StringEscapeUtils.escapeHtml4(tip)).append('\n');

        message.setText(sb.toString());
        try {
            mailSender.send(message);
            logger.info("Email sent successfully");
        } catch (Exception e) {
            logger.error("Error sending email: ", e);
        }
    }

    public void sendEmail(String name, String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(EMAIL_USERNAME); // Replace with your actual email address
        message.setSubject("New Search Party Signup");

        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Email: ").append(email).append("\n");

        message.setText(sb.toString());
        try {
            mailSender.send(message);
            logger.info("Email sent successfully");
        } catch (Exception e) {
            logger.error("Error sending email: ", e);
        }
    }

    public void sendEmail(String name, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(EMAIL_USERNAME); // Replace with your actual email address
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            logger.info("Email sent successfully");
        } catch (Exception e) {
            logger.error("Error sending email: ", e);
        }
    }

}
