package com.projetopweb1.learningdocs.presentation.dto.topic;

import com.projetopweb1.learningdocs.application.messages.MessagesENUM;

import javax.validation.constraints.NotBlank;

public class TopicRegisterDTO {
    @NotBlank(message = MessagesENUM.INVALID_FIELDS)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
