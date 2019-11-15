package com.example.service;

import com.example.entity.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-10-30 16:27
 */
@Component
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 简单发送邮件
     *
     * @param
     * @return
     * @author wanggang
     * @date 2019-10-31
     */
    @Override
    public void sendSimpleMail(Mail email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getFrom());
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getContent());

        javaMailSender.send(message);
    }

    /**
     * 发送 html 格式邮件
     *
     * @param
     * @return
     * @author wanggang
     * @date 2019-10-31
     */
    @Override
    public void sendHtmlMail(Mail email) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(email.getFrom());
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getContent(), true);
            javaMailSender.send(message);

        } catch (MessagingException e) {

        }
    }

    /**
     * 发送带附件的邮件
     *
     * @param
     * @return
     * @author wanggang
     * @date 2019-10-31
     */
    @Override
    public void sendAttachmentsMail(Mail email) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(email.getFrom());
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getContent(), true);

            String filePath = email.getAttachPath();

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            javaMailSender.send(message);

        } catch (MessagingException e) {

        }
    }
}