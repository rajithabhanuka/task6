package com.code.task6.service;

import com.code.task6.exception.EmailSenderException;

public interface EmailExecutorService {

    void sendEmailWithTemplateV1() throws EmailSenderException;

    void sendEmailWithTemplateV2(int userId) throws EmailSenderException;

    void sendEmailWithoutTemplate() throws EmailSenderException;

}
