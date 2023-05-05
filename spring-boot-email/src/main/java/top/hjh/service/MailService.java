package top.hjh.service;

import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 18 13 50
 **/
@Service
public class MailService {
    //通过这个对象发邮件
    @Resource
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;

    /**
     *
     * @param to 被发送方邮箱地址
     * @param subject 邮件标题
     * @param content 邮件内容
     */
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(content);
        message.setSubject(subject);
        message.setTo(to);
        message.setFrom(from);
        javaMailSender.send(message);
    }

    /**
     *
     * @param to 被发送方邮箱地址
     * @param subject 邮件标题
     * @param content 邮件内容
     */
    public void sendMimeMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        javaMailSender.send(message);
    }


}
