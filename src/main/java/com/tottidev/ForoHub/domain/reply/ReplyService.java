package com.tottidev.ForoHub.domain.reply;

import com.tottidev.ForoHub.domain.topic.TopicRepository;
import com.tottidev.ForoHub.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReplyRepository replyRepository;

    public ReplyDataDisplay createReply(ReplyData replyData) {

        var topic = topicRepository.findById(replyData.topic())
                .orElseThrow(() -> new IllegalArgumentException("Topic not found"));

        var author = userRepository.findById(replyData.author())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        var reply = new Reply(replyData.message(), author, topic);
        replyRepository.save(reply);
        return new ReplyDataDisplay(reply);


    }

    public ReplyDataDisplay updateReply(Long id, ReplyData replyData) {

        var reply = replyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reply not found"));

        var topic = topicRepository.findById(replyData.topic())
                .orElseThrow(() -> new IllegalArgumentException("Topic not found"));

        var author = userRepository.findById(replyData.author())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        reply.setMessage(replyData.message());
        reply.setAuthor(author);
        reply.setTopic(topic);

        return new ReplyDataDisplay(reply);
    }

    public void deleteReply(Long id) {
        var reply = replyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reply not found"));
        replyRepository.delete(reply);
    }
}
