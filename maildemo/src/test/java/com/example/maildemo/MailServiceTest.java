package com.example.maildemo;

import com.example.maildemo.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest extends MailDemoApplicationTests {

    @Autowired
    MailService mailService;

    @Value("${spring.mail.username}")
    String from;

    private String to = "473727906@qq.com";


    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail(
                from,
                to,
                "xxx@xxx.com ",
                "测试邮件主题",
                "测试邮件内容");
    }

    @Test
    public void sendAttachFileMail() {
        mailService.sendAttachFileMail(
                from,
                to,
                "测试邮件主题 sendAttachFileMail",
                "测试邮件内容 sendAttachFileMail",
                new File("C:\\Users\\niefeng\\Desktop\\城市导入导出模板.xlsx"));
    }

    @Test
    public void sendMailWithImg() {
        mailService.sendMailWithImg(
                from,
                to,
                "测试邮件主题(图片)",
                "<div>hello,这是一封带图片资源的邮件：" +
                        "这是图片1：<div><img src='cid:p01'/></div>" +
                        "这是图片2：<div><img src='cid:p02'/></div>" +
                        "</div>",
                new String[]{
                        "C:\\Users\\niefeng\\Desktop\\bgpic.png",
                        "C:\\Users\\niefeng\\Desktop\\00google-killer-superJumbo.webp"
                },
                new String[]{"p01", "p02"});
    }

}
