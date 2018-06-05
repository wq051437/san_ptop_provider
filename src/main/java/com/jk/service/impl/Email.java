package com.jk.service.impl;


import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by liukang on 2018/5/29.
 */
public class Email {
    private String email;
    private String title;
    private String context;

    public Email(String email, String context,String title) {
        this.email = email;
        this.context = context;
        this.title=title;
    }
    public String sf() throws Exception {
        //收件人电子邮箱
        //发件人电子邮箱
        String from="383194576@qq.com";
        //指定发送邮件的主机 smtp.qq.com   QQ邮件的服务器
        String host="smtp.qq.com";
        //获取系统属性
        Properties properties = System.getProperties();
        //设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        //获取session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("383194576@qq.com", "pwrbhehmokvxbgdj"); //发件人邮件用户名、密码
            }
        });
        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
            // Set Subject: 头部头字段
            message.setSubject(title);
            // 设置消息体
            message.setText(context);
            // 发送消息
            Transport.send(message);
            System.out.println("邮件发送成功");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return "success";
    }
}
