package com.projetopweb1.learningdocs.presentation.dto.topicnote;

import com.projetopweb1.learningdocs.application.messages.MessagesENUM;

import javax.validation.constraints.NotBlank;

public class TopicNoteEditDTO {
    @NotBlank(message = MessagesENUM.INVALID_FIELDS)
    private String title;
    @NotBlank(message = MessagesENUM.INVALID_FIELDS)
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
