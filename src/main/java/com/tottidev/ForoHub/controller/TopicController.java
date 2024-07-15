package com.tottidev.ForoHub.controller;

import com.tottidev.ForoHub.domain.topic.TopicData;
import com.tottidev.ForoHub.domain.topic.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;


    @PostMapping
    @Transactional
    public ResponseEntity<?> createTopic(@RequestBody @Valid TopicData topicData) {
        var topic = topicService.createTopic(topicData);
        return ResponseEntity.ok(topic);
    }

}
