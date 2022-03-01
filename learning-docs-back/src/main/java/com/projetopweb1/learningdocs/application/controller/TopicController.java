package com.projetopweb1.learningdocs.application.controller;

import com.projetopweb1.learningdocs.domain.model.Topic;
import com.projetopweb1.learningdocs.domain.service.TopicService;
import com.projetopweb1.learningdocs.presentation.dto.topic.TopicDTO;
import com.projetopweb1.learningdocs.presentation.dto.topic.TopicRegisterDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/new")
    public ResponseEntity<?> createTopic(@Valid @RequestBody TopicRegisterDTO topicRegisterDTO){
        return new ResponseEntity<>(
                modelMapper.map(topicService.createTopic(modelMapper.map(topicRegisterDTO, Topic.class)),TopicDTO.class),
                HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Topic>> listTopics(){
        List<Topic> topics = topicService.listTopic();
        return new ResponseEntity(topics
                .stream()
                .map(topic -> modelMapper.map(topic, TopicDTO.class))
                ,HttpStatus.OK);
    }

    @DeleteMapping("/{topicID}")
    public ResponseEntity<?> deleteTopic(@PathVariable(value = "topicID") int topicID){
        topicService.deleteTopic(topicID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
