package com.example.service;

import com.example.entity.Mail;

/**
 * @author wanggang
 * @program javademo
 * @description
 * @create 2019-10-30 18:06
 */

public interface MailService {
    void sendSimpleMail(Mail email);

    void sendHtmlMail(Mail email);

    void sendAttachmentsMail(Mail email);
}