package com.code.task6.service;

import com.code.task6.dto.EmailDto;
import com.code.task6.dto.PlanDto;
import com.code.task6.exception.EmailSenderException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EmailExecutorServiceImpl implements EmailExecutorService{

    private final EmailService emailService;

    @Autowired
    public EmailExecutorServiceImpl(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void sendEmailWithTemplateV1() throws EmailSenderException {

        log.info("SENDING EMAIL WITH TEMPLATE");

        emailService.sendEmailWithTemplate(getEmail("template1.flth"));
    }

    @Override
    public void sendEmailWithTemplateV2() throws EmailSenderException {

        log.info("SENDING PLAN EMAIL WITH TEMPLATE");

        emailService.sendEmailWithTemplate(getEmail("template2.flth"), getPlanDtos());
    }

    @Override
    public void sendEmailWithoutTemplate() throws EmailSenderException {

        log.info("SENDING EMAIL WITHOUT TEMPLATE");

        emailService.sendEmailWithoutTemplate(getEmail("template1.flth"));
    }

    private EmailDto getEmail(String template){

        EmailDto mail = new EmailDto();
        mail.setFrom("automated@noreply");
        mail.setTo("rajithabhanuka1@gmail.com");
        mail.setSubject("Test Email");
        mail.setTemplate(template);

        return mail;
    }

    private List<PlanDto> getPlanDtos() {

        List<PlanDto> planDtos = new ArrayList<>();

        PlanDto p1 = new PlanDto();
        p1.setPlanLevel("Enterprise Functions > Wells Fargo Technology");
        p1.setRole("Monitoring Plan Owner");
        p1.setType("REMOVE");

        PlanDto p2 = new PlanDto();
        p2.setPlanLevel("Enterprise Functions > Legal Department");
        p2.setRole("Monitoring Plan Proxy");
        p2.setType("REMOVE");

        PlanDto p3 = new PlanDto();
        p3.setPlanLevel("Enterprise Risk Types > Operational Risk > Information Risk Management");
        p3.setRole("Monitoring Activity Owner");
        p3.setType("REMOVE");

        planDtos.add(p1);
        planDtos.add(p2);
        planDtos.add(p3);
        return planDtos;
    }
}
