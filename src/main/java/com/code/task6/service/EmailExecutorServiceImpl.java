package com.code.task6.service;

import com.code.task6.dto.EmailDto;
import com.code.task6.exception.EmailSenderException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailExecutorServiceImpl implements EmailExecutorService{

    private final EmailService emailService;

    @Autowired
    public EmailExecutorServiceImpl(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void sendEmailWithTemplate() throws EmailSenderException {

        log.info("SENDING EMAIL WITH TEMPLATE");

        emailService.sendEmailWithTemplate(getEmail());
    }

    @Override
    public void sendEmailWithoutTemplate() throws EmailSenderException {

        log.info("SENDING EMAIL WITHOUT TEMPLATE");

        emailService.sendEmailWithoutTemplate(getEmail());
    }

    private EmailDto getEmail(){

        EmailDto mail = new EmailDto();
        mail.setFrom("automated@noreply");
        mail.setTo("rajithabhanuka1@gmail.com");
        mail.setSubject("Test Email");
        mail.setTemplate("template1.flth");

        return mail;
    }
}
