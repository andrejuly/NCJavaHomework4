package com.company.controller;

import com.company.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MailController {

    @Autowired
    public JavaMailSender javaMailSender;

    @GetMapping("/send")
    public String sendMail(Model model) {
        model.addAttribute("mail",new Mail());
        return "send";
    }

    @PostMapping("/send")
    public String greetingSubmit(@ModelAttribute Mail mail) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("russobarocco1@gmail.com");
        msg.setTo(Mail.getTo());
        msg.setSubject(mail.getSubject());
        msg.setText(mail.getText());
        javaMailSender.send(msg);
        return "sendedEmail";
    }
}
