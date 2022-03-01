package com.projetopweb1.learningdocs.domain.model;

import javax.persistence.*;

@Entity(name = "TB_TOPIC_VIDEO")
public class TopicVideo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String videoUrl;
    private String embedUrl;
    @ManyToOne
    Topic topic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
