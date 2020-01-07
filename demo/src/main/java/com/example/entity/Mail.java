package com.example.entity;

import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @program: javademo
 * @description:
 * @author: wanggang
 * @create: 2019-10-30 11:12
 */
@Configuration
public class Mail {
    /**
     * 邮件发送人
     */
    private String from;

    /**
     * 邮件接收人
     */
    private String to;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String content;

    /**
     * 邮件主题
     */
    private String type;

    /**
     * 发送邮件模板时的模板文件名
     */
    private String templateName;

    /**
     * 模板参数
     */
    private Map<String, Object> variables;

    /**
     * 附件地址
     */
    private String attachPath;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    public String getAttachPath() {
        return attachPath;
    }

    public void setAttachPath(String attachPath) {
        this.attachPath = attachPath;
    }
}