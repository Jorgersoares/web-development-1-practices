package com.projetopweb1.learningdocs.presentation.dto.topicvideo;

import com.projetopweb1.learningdocs.application.messages.MessagesENUM;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

public class TopicVideoRegisterDTO {
    @NotBlank(message = MessagesENUM.INVALID_FIELDS)
    private int topicId;

    @NotBlank(message = MessagesENUM.INVALID_FIELDS)
    @URL(message = MessagesENUM.INVALID_URL)
    private String videoUrl;

    @NotBlank(message = MessagesENUM.INVALID_FIELDS)
    @URL(message = MessagesENUM.INVALID_URL)
    private String embedUrl;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

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
