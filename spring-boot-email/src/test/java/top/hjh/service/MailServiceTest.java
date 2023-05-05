package top.hjh.service;

import freemarker.template.Template;
import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import top.hjh.entity.Article;

import java.time.temporal.Temporal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author huang
 * @Description
 * @Date 2023 04 18 13 54
 **/
@SpringBootTest
class MailServiceTest {

    @Resource
    private  MailService mailService;

    @Resource
    private FreeMarkerConfig freeMarkerConfig;


    @Test
    void sendSimpleMail() {
        mailService.sendSimpleMail("2975800991@qq.com","第一次发邮件","你好");
    }

    @Test
    void sendMimeMail() throws MessagingException {
        String content="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>FreeMarker 邮件</title>\n" +
                "</head>\n" +
                "<style>\n" +
                "    h1{\n" +
                "        background-color: cyan;\n" +
                "    }\n" +
                "</style>\n" +
                "<body>\n" +
                "<h1>这是一封 Freemarker邮件</h1>\n" +
                "\n" +
                "<table>\n" +
                "    <tr>\n" +
                "        <td>序号</td>\n" +
                "        <td>标题</td>\n" +
                "        <td>创建时间</td>\n" +
                "\n" +
                "    </tr>\n" +
                "<img src=\"https://img1.baidu.com/it/u=413643897,2296924942&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500\">\n" +
                "    <#list articles as article>\n" +
                "        <tr>\n" +
                "            <td>${article.id}</td>\n" +
                "            <td>${article.title}</td>\n" +
                "            <td>${article.createTime?string('yyyy-MM-dd hh:mm:ss')}</td>\n" +
                "\n" +
                "        </tr>\n" +
                "    </#list>\n" +
                "</table>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        mailService.sendMimeMail("2975800991@qq.com","第一次发邮件",content);
    }
    @Test
    void sendFreeMarkerMail() throws  Exception{
        List<Article> articles=List.of(
        new Article(1,"Spring",new Date()),
        new Article(2,"Spring Mvc",new Date()),
        new Article(3,"Spring Boot",new Date())
        );

        Template template=freeMarkerConfig.getConfiguration().getTemplate("mail-temp.ftl");
        Map<String,Object> map=new HashMap<>();

        map.put("articles",articles);
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template,map);
        mailService.sendMimeMail("2975800991@qq.com","第一次发邮件",content);
    }

    }
