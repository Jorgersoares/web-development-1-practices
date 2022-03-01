package com.projetopweb1.learningdocs.domain.service;

import com.projetopweb1.learningdocs.domain.model.TopicNote;

import java.util.List;

public interface TopicNoteService {
    TopicNote createTopicNote(TopicNote topicNote, int topicID);
    List<TopicNote> listTopicNoteByTopicID(int topicID);
}
