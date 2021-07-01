package com.code.task6.service;

import com.code.task6.exception.EmailSenderException;

public interface EmailExecutorService {

    void sendEmailWithTemplate() throws EmailSenderException;

    void sendEmailWithoutTemplate() throws EmailSenderException;

}
