package com.code.task6.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmailSenderException extends Exception {

    private final String message;

}
