package com.projetopweb1.learningdocs.infrastructure.persistence.hibernate;

import com.projetopweb1.learningdocs.domain.model.Topic;
import com.projetopweb1.learningdocs.domain.model.TopicNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicNoteRepository extends JpaRepository<TopicNote, Integer> {
    List<TopicNote> findAllByTopic(Topic topic);
}
