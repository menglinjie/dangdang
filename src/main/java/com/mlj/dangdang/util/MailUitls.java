package com.mlj.dangdang.util;

import com.sun.mail.util.MailSSLSocketFactory;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具类
 *
 * @author menglinjie
 */
public class MailUitls {
    /**
     * 发送邮件的方法
     *
     * @param to   :收件人
     * @param code :激活码
     */
    public static void sendMail(String to, int code) {
        /**
         * 1.获得一个Session对象.
         * 2.创建一个代表邮件的对象Message.
         * 3.发送邮件Transport
         */
        // 1.获得连接对象
        Properties props = new Properties();
        props.setProperty("mail.debug", "true");
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(props, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("2411988749@qq.com", "ukjauojyzsacebae");
            }

        });
        // 2.创建邮件对象:
        Message message = new MimeMessage(session);
        // 设置发件人:
        try {
            message.setFrom(new InternetAddress("2411988749@qq.com"));
            // 设置收件人:
            message.addRecipient(RecipientType.TO, new InternetAddress(to));
            // 抄送 CC   密送BCC
            // 设置标题
            message.setSubject("来自官方激活邮件");
            // 设置邮件正文:
            message.setContent("<h1>官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://localhost:8080/user/activate.action?code=" + code + "'>http://localhost:8080/user/activate.action?code=" + code + "</a></h3>", "text/html;charset=UTF-8");
            // 3.发送邮件:
            Transport.send(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }


}