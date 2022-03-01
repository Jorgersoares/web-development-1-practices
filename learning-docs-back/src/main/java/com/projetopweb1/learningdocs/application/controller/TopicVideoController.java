package com.projetopweb1.learningdocs.application.controller;

import com.projetopweb1.learningdocs.domain.model.TopicNote;
import com.projetopweb1.learningdocs.domain.model.TopicVideo;
import com.projetopweb1.learningdocs.domain.service.TopicVideoService;
import com.projetopweb1.learningdocs.presentation.dto.topicvideo.TopicVideoDTO;
import com.projetopweb1.learningdocs.presentation.dto.topicvideo.TopicVideoEditDTO;
import com.projetopweb1.learningdocs.presentation.dto.topicvideo.TopicVideoRegisterDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/topic-video")
public class TopicVideoController {

    @Autowired
    private TopicVideoService topicVideoService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/new")
    public ResponseEntity<?> createTopicVideo(@Valid @RequestBody TopicVideoRegisterDTO topicVideoRegisterDTO){
        return new ResponseEntity<>(
                modelMapper.map(topicVideoService.createTopicVideo(modelMapper.map(topicVideoRegisterDTO, TopicVideo.class), topicVideoRegisterDTO.getTopicId()), TopicVideoEditDTO.class),
                HttpStatus.CREATED);
    }


    @GetMapping("/list")
    public ResponseEntity<List<TopicNote>> listTopicNote(@RequestParam int topicID){
        List<TopicVideo> videos = topicVideoService.listTopicVideoByTopicID(topicID);
        return new ResponseEntity(videos
                .stream()
                .map(video -> modelMapper.map(video, TopicVideoDTO.class)),
                HttpStatus.OK);
    }

    @DeleteMapping("/{topicNoteID}")
    public ResponseEntity<?> deleteTopicNote(@PathVariable(value = "topicNoteID") int topicNoteID){
        topicVideoService.deleteTopicVideo(topicNoteID);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

