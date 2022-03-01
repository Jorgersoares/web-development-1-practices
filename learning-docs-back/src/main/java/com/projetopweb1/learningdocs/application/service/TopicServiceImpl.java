package com.projetopweb1.learningdocs.application.service;

import com.projetopweb1.learningdocs.application.messages.MessagesENUM;
import com.projetopweb1.learningdocs.domain.exceptions.BusinessException;
import com.projetopweb1.learningdocs.domain.model.Topic;
import com.projetopweb1.learningdocs.domain.service.TopicService;
import com.projetopweb1.learningdocs.infrastructure.persistence.hibernate.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicRepository topicRepository;

    @Override
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public List<Topic> listTopic() {
        return topicRepository.findAll();
    }

    @Override
    public void deleteTopic(int id) {
        if(topicRepository.findById(id).isPresent()){
            topicRepository.deleteById(id);
        }
        else{
            throw new BusinessException(MessagesENUM.TOPIC_NOT_FOUND);
        }
    }
}
