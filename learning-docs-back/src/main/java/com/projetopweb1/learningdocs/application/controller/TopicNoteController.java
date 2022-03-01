package com.projetopweb1.learningdocs.application.controller;

import com.projetopweb1.learningdocs.domain.model.TopicNote;
import com.projetopweb1.learningdocs.domain.service.TopicNoteService;
import com.projetopweb1.learningdocs.presentation.dto.topicnote.TopicNoteDTO;
import com.projetopweb1.learningdocs.presentation.dto.topicnote.TopicNoteRegisterDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/topic-note")
public class TopicNoteController {

    @Autowired
    private TopicNoteService topicNoteService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/new")
    public ResponseEntity<?> createTopicNote(@Valid @RequestBody TopicNoteRegisterDTO topicNoteRegisterDTOD){
        return new ResponseEntity<>(
                modelMapper.map(topicNoteService.createTopicNote(modelMapper.map(topicNoteRegisterDTOD, TopicNote.class), topicNoteRegisterDTOD.getTopicId()), TopicNoteDTO.class),
                HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TopicNote>> listTopicNote(@RequestParam int topicID){
        List<TopicNote> notes = topicNoteService.listTopicNoteByTopicID(topicID);
        return new ResponseEntity(notes
                .stream()
                .map(note -> modelMapper.map(note, TopicNoteDTO.class)),
                HttpStatus.OK);
    }
}
