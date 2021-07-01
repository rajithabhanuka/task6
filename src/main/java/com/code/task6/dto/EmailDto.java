package com.code.task6.dto;

import lombok.Data;

import java.util.Map;

@Data
public class EmailDto {

    private String to;

    private String from;

    private String subject;

    private String content;

    private String template;

    private Map<String, Object > model;

}
