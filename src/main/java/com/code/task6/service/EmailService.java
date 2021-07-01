package com.code.task6.service;

import com.code.task6.dto.EmailDto;
import com.code.task6.exception.EmailSenderException;


public interface EmailService {

   String sendEmailWithTemplate(EmailDto mail) throws EmailSenderException;

   String sendEmailWithoutTemplate(EmailDto mail) throws EmailSenderException;
}
