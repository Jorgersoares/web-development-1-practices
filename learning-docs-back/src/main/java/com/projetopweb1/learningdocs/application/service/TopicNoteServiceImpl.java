package com.projetopweb1.learningdocs.application.service;

import com.projetopweb1.learningdocs.application.messages.MessagesENUM;
import com.projetopweb1.learningdocs.domain.exceptions.BusinessException;
import com.projetopweb1.learningdocs.domain.model.Topic;
import com.projetopweb1.learningdocs.domain.model.TopicNote;
import com.projetopweb1.learningdocs.domain.service.TopicNoteService;
import com.projetopweb1.learningdocs.infrastructure.persistence.hibernate.TopicNoteRepository;
import com.projetopweb1.learningdocs.infrastructure.persistence.hibernate.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicNoteServiceImpl implements TopicNoteService {
    @Autowired
    TopicNoteRepository topicNoteRepository;
    @Autowired
    TopicRepository topicRepository;

    @Override
    public TopicNote createTopicNote(TopicNote topicNote, int topicID) {
        Topic topic = topicRepository.getOne(topicID);
        topicNote.setTopic(topic);
        return topicNoteRepository.save(topicNote);

    }

    @Override
    public List<TopicNote> listTopicNoteByTopicID(int topicID) {
        if(topicRepository.existsById(topicID)){
            Topic topic = topicRepository.getOne(topicID);
            return topicNoteRepository.findAllByTopic(topic);
        }
        throw new BusinessException(MessagesENUM.TOPIC_NOTES_NOT_FOUND);
    }
}
