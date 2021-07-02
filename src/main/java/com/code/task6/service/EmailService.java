package com.code.task6.service;

import com.code.task6.dto.EmailDto;
import com.code.task6.dto.PlanDto;
import com.code.task6.exception.EmailSenderException;

import java.util.List;


public interface EmailService {

   String sendEmailWithTemplate(EmailDto mail) throws EmailSenderException;

   String sendEmailWithTemplate(EmailDto mail, List<PlanDto> planDtos) throws EmailSenderException;

   String sendEmailWithoutTemplate(EmailDto mail) throws EmailSenderException;
}
