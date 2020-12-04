package com.study.testmail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SendMailController {
    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping("/sendMail")
    @ResponseBody
    public void testSend() {
        //String title,String content,String... to
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("liuhai19920613@163.com");
            message.setTo("1020214550@qq.com");
            message.setSubject("title");
            message.setText("content");
            javaMailSender.send(message);
        } catch (Exception exception) {

        }
    }
}
