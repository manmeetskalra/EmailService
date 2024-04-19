package com.spring.EmailService.Service;

import java.io.File;
import java.io.InputStream;

public interface EmailService {

    // send email to one people
    void sendEmail(String to, String subject, String message);

    // send email to multiple people
    void sendEmail(String[] to, String subject, String message);

    // send email with HTML
    void sendEmailWithHtml(String to, String subject, String htmlContent);

    // send email with file
    void sendEmailWithFile(String to, String subject, String message, InputStream is);
}
