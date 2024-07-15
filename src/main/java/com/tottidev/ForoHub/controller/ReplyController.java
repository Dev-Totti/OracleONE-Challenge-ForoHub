package com.tottidev.ForoHub.controller;

import com.tottidev.ForoHub.domain.reply.*;
import com.tottidev.ForoHub.domain.topic.TopicRepository;
import com.tottidev.ForoHub.domain.user.UserRepository;
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
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @Autowired
    private ReplyRepository replyRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> createReply(@RequestBody @Valid ReplyData replyData, UriComponentsBuilder uriComponentsBuilder) {
        var reply = replyService.createReply(replyData);
        URI url = uriComponentsBuilder.path("/reply/{id}").buildAndExpand(reply.id()).toUri();

        return ResponseEntity.created(url).body(reply);
    }

    @GetMapping
    public ResponseEntity<Page<ReplyDataDisplay>> getReplies(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(replyRepository.findAll(pageable).map(ReplyDataDisplay::new));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateReply(@PathVariable Long id, @RequestBody @Valid ReplyData replyData, UriComponentsBuilder uriComponentsBuilder) {
        var reply = replyService.updateReply(id, replyData);
        URI url = uriComponentsBuilder.path("/reply/{id}").buildAndExpand(reply.id()).toUri();

        return ResponseEntity.created(url).body(reply);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteReply(@PathVariable Long id) {
        replyService.deleteReply(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReplyDataDisplay> getReply(@PathVariable Long id) {
        Reply reply = replyRepository.getReferenceById(id);

        return ResponseEntity.ok(new ReplyDataDisplay(reply));
    }

}
