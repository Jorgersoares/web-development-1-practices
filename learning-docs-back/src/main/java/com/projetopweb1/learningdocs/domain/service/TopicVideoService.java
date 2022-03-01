package com.projetopweb1.learningdocs.domain.service;

import com.projetopweb1.learningdocs.domain.model.TopicVideo;

import java.util.List;

public interface TopicVideoService {
    TopicVideo createTopicVideo(TopicVideo topicVideo, int topicID);
    List<TopicVideo> listTopicVideoByTopicID(int topicID);
    void deleteTopicVideo(int id);
}
