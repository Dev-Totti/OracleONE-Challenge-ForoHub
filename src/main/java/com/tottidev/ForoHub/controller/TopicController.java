package com.tottidev.ForoHub.controller;

import com.tottidev.ForoHub.domain.topic.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicService topicService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> createTopic(@RequestBody @Valid TopicDataCreate topicData, UriComponentsBuilder uriComponentsBuilder) {
        var topic = topicService.createTopic(topicData);
        URI url = uriComponentsBuilder.path("/topic/{id}").buildAndExpand(topic.id()).toUri();

        return ResponseEntity.created(url).body(topic);
    }

    @GetMapping
    public ResponseEntity<Page<TopicDataDisplay>> getTopics(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(topicRepository.findAll(pageable).map(TopicDataDisplay::new));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateTopic(@PathVariable Long id, @RequestBody @Valid TopicDataUpdate topicDataUpdate, UriComponentsBuilder uriComponentsBuilder) {
        var topic = topicService.updateTopic(id, topicDataUpdate);
        URI url = uriComponentsBuilder.path("/topic/{id}").buildAndExpand(topic.id()).toUri();

        return ResponseEntity.created(url).body(topic);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDataDisplay> getTopic(@PathVariable Long id) {
        com.tottidev.ForoHub.domain.topic.Topic topic = topicRepository.getReferenceById(id);
        return ResponseEntity.ok(new TopicDataDisplay(topic));
    }

}
