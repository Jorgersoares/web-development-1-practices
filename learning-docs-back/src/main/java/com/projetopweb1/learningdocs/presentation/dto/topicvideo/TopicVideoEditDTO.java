package com.projetopweb1.learningdocs.presentation.dto.topicvideo;

import com.projetopweb1.learningdocs.application.messages.MessagesENUM;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

public class TopicVideoEditDTO {
    @NotBlank(message = MessagesENUM.INVALID_FIELDS)
    @URL(message = MessagesENUM.INVALID_URL)
    private String videoUrl;

    @NotBlank(message = MessagesENUM.INVALID_FIELDS)
    @URL(message = MessagesENUM.INVALID_URL)
    private String embedUrl;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }
}
