package com.example;

import com.example.entity.Mail;
import com.example.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSimpleMail() {
        Mail mail = new Mail();
        mail.setFrom("wanggang4521@163.com");
        mail.setTo("309754116@qq.com");
        mail.setSubject("主题");
        mail.setContent("内容");
        mailService.sendSimpleMail(mail);
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        Mail mail = new Mail();
        mail.setFrom("wanggang4521@163.com");
        mail.setTo("309754116@qq.com");
        mail.setSubject("主题");
        mail.setContent(content);

        mailService.sendHtmlMail(mail);
    }

    @Test
    public void TestAttachmentsMail() {
        Mail mail = new Mail();
        mail.setFrom("wanggang4521@163.com");
        mail.setTo("309754116@qq.com");
        mail.setSubject("主题");
        mail.setContent("内容");
        mail.setAttachPath("e:\\tmp\\application.log");
        mailService.sendAttachmentsMail(mail);
    }

    @Test
    public void sendTemplateMail() {

        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        Mail mail = new Mail();
        mail.setFrom("wanggang4521@163.com");
        mail.setTo("309754116@qq.com");
        mail.setSubject("主题");
        mail.setContent(emailContent);

        mailService.sendHtmlMail(mail);
    }
}