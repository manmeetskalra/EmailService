package com.spring.EmailService;

import com.spring.EmailService.Service.EmailService;
import com.spring.EmailService.Service.EmailServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailService emailService;

    @Test
    void emailSendTest() {
        System.out.println("Sending email");
        emailService.sendEmail("manmeet.singh236@gmail.com","Test Email", "Test Email Text");
    }

    @Test
    void emailSendTestToBulk() {
        System.out.println("Sending email to Bulk");

        String[] emails = new String[]{"manmeet.singh236@gmail.com","manmeet.singh.kalra18@gmail.com","narinder.kaur.kalra18@gmail.com"};

        emailService.sendEmail(emails,"Test Email", "Test Email Text");
    }

    @Test
    void emailSendTestWithHtml() {
        System.out.println("Sending email with html");
        String html = "" +
                "<h1 style='color:red;border:1px solid red;'>Welcome to my world</h1>" +
                "";
        emailService.sendEmailWithHtml("manmeet.singh236@gmail.com","Test Email", html);
    }

    @Test
    void emailSendTestWithFile() {
        System.out.println("Sending email with File");

        File file = new File("/Users/manme/Desktop/0818d379-1f37-48e3-8757-739d5a5419aa.jpg");

        try {
            InputStream is = new FileInputStream(file);
            emailService.sendEmailWithFile("manmeet.singh236@gmail.com","Test Email", "Test Email Text", is);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
