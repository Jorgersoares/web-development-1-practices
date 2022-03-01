package com.projetopweb1.learningdocs.domain.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "TB_TOPIC")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private Set<TopicNote> notes;
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private Set<TopicVideo> videos;

    public Set<TopicVideo> getVideos() {
        return videos;
    }

    public void setVideos(Set<TopicVideo> videos) {
        this.videos = videos;
    }

    public Set<TopicNote> getNotes() {
        return notes;
    }

    public void setNotes(Set<TopicNote> notes) {
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
