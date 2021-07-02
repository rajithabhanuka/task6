package com.code.task6.controller;

import com.code.task6.service.EmailExecutorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EmailController {

    private final EmailExecutorService emailExecutorService;

    @Autowired
    public EmailController(EmailExecutorService emailExecutorService) {
        this.emailExecutorService = emailExecutorService;
    }

    @GetMapping(value = "/v1/mail/send-with-template")
    public void sendEmailWithTemplateV1(){
        try{
            emailExecutorService.sendEmailWithTemplateV1();
        }catch (Exception e){
            log.error("ERROR OCCURRED WHILE SENDING EMAIL WITH TEMPLATE");
        }

    }

    @GetMapping(value = "/v2/mail/send-with-template")
    public void sendEmailWithTemplateV2(){
        try{
            emailExecutorService.sendEmailWithTemplateV2();
        }catch (Exception e){
            log.error("ERROR OCCURRED WHILE SENDING EMAIL WITH TEMPLATE");
        }

    }

    @GetMapping(value = "/v1/mail/send-without-template")
    public void sendEmailWithoutTemplate(){
        try{
            emailExecutorService.sendEmailWithoutTemplate();
        }catch (Exception e){
            log.error("ERROR OCCURRED WHILE SENDING EMAIL WITHOUT TEMPLATE");
        }

    }

    @GetMapping(value = "/plan/{planId}")
    public ResponseEntity<String> getString(
            @PathVariable(value = "planId") String planId){

        return ResponseEntity.ok("Success :" + planId);
    }
}
