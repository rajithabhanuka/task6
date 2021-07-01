package com.code.task6.service;

import com.code.task6.dto.EmailDto;
import freemarker.template.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.*;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Value("${back.end.url}")
    private String backend;

    private final JavaMailSender emailSender;
    private final Configuration fmConfiguration;

    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender,
                            Configuration fmConfiguration) {
        this.emailSender = emailSender;
        this.fmConfiguration = fmConfiguration;
    }


    @Override
    public String sendEmailWithTemplate(EmailDto mail) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        String msg;

        try {

            Map<String, Object> model = new HashMap<>();
            model.put("subject", mail.getSubject());
            model.put("backend", backend.replace("{planId}", "1"));

            mail.setModel(model);

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setSubject(mail.getSubject());
            helper.setFrom(mail.getFrom());
            helper.setTo(mail.getTo());

            mail.setContent(geContentFromFreeMaker(mail.getModel(), mail.getTemplate()));

            helper.setText(mail.getContent(), true);

            emailSender.send(helper.getMimeMessage());
            msg = "Sent Email";

            log.info("--------------------------------------------------------------------");
            log.info("MAIL SENT TO : {} || USING TEMPLATE : {} || FIRST ATTEMPT ON: {}", mail.getTo(), mail.getTemplate(), new Date().toString());
            log.info("--------------------------------------------------------------------");

        } catch (MessagingException e) {
            log.error("----------------------------------------------------------------------");
            log.error("FAILED TO SEND EMAIL TO");
            log.error(e.getMessage());
            log.error("----------------------------------------------------------------------");
            msg = "Failed to Send Email";
        }

        return msg;

    }

    @Override
    public String sendEmailWithoutTemplate(EmailDto mail) {

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper;
        String bodyContent;
        String msg;
        try {
            helper = new MimeMessageHelper(message, true);

            helper.setFrom(mail.getFrom());
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());

            bodyContent = processEmailBody(mail.getSubject());
            helper.setText(bodyContent, true);

            log.debug(message.toString());

            emailSender.send(message);

            msg = "Sent Email";

            log.info("--------------------------------------------------------------------");
            log.info("MAIL SENT TO : {} || USING TEMPLATE : {} || FIRST ATTEMPT ON: {}", mail.getTo(), new Date().toString());
            log.info("--------------------------------------------------------------------");

        } catch (Exception e) {
            log.error("----------------------------------------------------------------------");
            log.error("FAILED TO SEND EMAIL TO : {}", mail.getTo());
            log.error(e.getMessage());
            log.error("----------------------------------------------------------------------");
            msg = "Failed to Send Email";

        }
        return msg;
    }


    private String processEmailBody(String subject) {

        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>");
        builder.append("<html lang=\"en\"");
        builder.append("<head>");
        builder.append("<title>" + subject + "</title>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append("<p style=\"font-style: italic;\">" + subject + "</p>");
        builder.append("<br>");
        builder.append("<span>The following has to be submitted : {planId}</span>");
        builder.append("<br>");
        builder.append("<br>");
        builder.append("<span>navigate to Plan : <a href=\"" + backend.replace("{planId}", "1") + "\">link</a></span>");
        builder.append("<br>");
        builder.append("<br>");
        builder.append("</body>");
        builder.append("</html>");

        return builder.toString();
    }

    public String geContentFromFreeMaker(Map<String, Object> model, String template) {
        StringBuffer content = new StringBuffer();

        try {
            content.append(FreeMarkerTemplateUtils
                    .processTemplateIntoString(fmConfiguration.getTemplate(template), model));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
