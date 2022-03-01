package com.projetopweb1.learningdocs.domain.service;

import com.projetopweb1.learningdocs.domain.model.Topic;

import java.util.List;

public interface TopicService {
    Topic createTopic(Topic topic);
    List<Topic> listTopic();
    void deleteTopic(int id);
}
