package com.projetopweb1.learningdocs.application.service;

import com.projetopweb1.learningdocs.application.messages.MessagesENUM;
import com.projetopweb1.learningdocs.domain.exceptions.BusinessException;
import com.projetopweb1.learningdocs.domain.model.Topic;
import com.projetopweb1.learningdocs.domain.model.TopicVideo;
import com.projetopweb1.learningdocs.domain.service.TopicVideoService;
import com.projetopweb1.learningdocs.infrastructure.persistence.hibernate.TopicRepository;
import com.projetopweb1.learningdocs.infrastructure.persistence.hibernate.TopicVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicVideoServiceImpl implements TopicVideoService {
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    TopicVideoRepository topicVideoRepository;

    @Override
    public TopicVideo createTopicVideo(TopicVideo topicVideo, int topicID) {
        Topic topic = topicRepository.getOne(topicID);
        topicVideo.setTopic(topic);
        return topicVideoRepository.save(topicVideo);
    }

    @Override
    public List<TopicVideo> listTopicVideoByTopicID(int topicID) {
        if(topicRepository.existsById(topicID)){
            Topic topic = topicRepository.getOne(topicID);
            return topicVideoRepository.findAllByTopic(topic);
        }
        throw new BusinessException(MessagesENUM.TOPIC_VIDEOS_NOT_FOUND);
    }

    @Override
    public void deleteTopicVideo(int id) {
        if(topicVideoRepository.existsById(id)){
            topicVideoRepository.deleteById(id);
        }
        else{
            throw new BusinessException(MessagesENUM.VIDEO_NOT_FOUND);
        }
    }
}
