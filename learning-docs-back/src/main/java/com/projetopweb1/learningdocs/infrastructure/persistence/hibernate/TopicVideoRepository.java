package com.projetopweb1.learningdocs.infrastructure.persistence.hibernate;

import com.projetopweb1.learningdocs.domain.model.Topic;
import com.projetopweb1.learningdocs.domain.model.TopicVideo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicVideoRepository extends JpaRepository<TopicVideo, Integer> {
    List<TopicVideo> findAllByTopic(Topic topic);
}
