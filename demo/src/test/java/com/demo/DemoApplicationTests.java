package com.demo;

import com.demo.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void loadPerson() {
        System.out.println(person);
    }

    @Test
    public void testHelloService() {
        Boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {

        logger.trace("这是Trace日志...");
        logger.debug("这是Debug日志...");
        logger.info("这是Info日志...");
        logger.warn("这是warn日志...");
    }

//    @Autowired
//    private MailService mailService;
//
//    @Autowired
//    private TemplateEngine templateEngine;

    //@Test
//    public void testSimpleMail() {
//        Mail mail = new Mail();
//        mail.setFrom("wanggang4521@163.com");
//        mail.setTo("309754116@qq.com");
//        mail.setSubject("主题");
//        mail.setContent("内容");
//        mailService.sendSimpleMail(mail);
//    }

//    @Test
//    public void testHtmlMail() throws Exception {
//        String content = "<html>\n" +
//                "<body>\n" +
//                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
//                "</body>\n" +
//                "</html>";
//        Mail mail = new Mail();
//        mail.setFrom("wanggang4521@163.com");
//        mail.setTo("309754116@qq.com");
//        mail.setSubject("主题");
//        mail.setContent(content);
//
//        mailService.sendHtmlMail(mail);
//    }

//    @Test
//    public void TestAttachmentsMail() {
//        Mail mail = new Mail();
//        mail.setFrom("wanggang4521@163.com");
//        mail.setTo("309754116@qq.com");
//        mail.setSubject("主题");
//        mail.setContent("内容");
//        mail.setAttachPath("e:\\tmp\\application.log");
//        mailService.sendAttachmentsMail(mail);
//    }

//    @Test
//    public void sendTemplateMail() {
//
//        Context context = new Context();
//        context.setVariable("id", "006");
//        String emailContent = templateEngine.process("emailTemplate", context);
//
//        Mail mail = new Mail();
//        mail.setFrom("wanggang4521@163.com");
//        mail.setTo("309754116@qq.com");
//        mail.setSubject("主题");
//        mail.setContent(emailContent);
//
//        mailService.sendHtmlMail(mail);
//    }
}