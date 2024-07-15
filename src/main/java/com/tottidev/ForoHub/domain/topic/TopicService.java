package com.tottidev.ForoHub.domain.topic;

import com.tottidev.ForoHub.domain.course.CourseRepository;
import com.tottidev.ForoHub.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public TopicDataDisplay createTopic(TopicDataCreate topicDataCreate) {

        var user = userRepository.findById(topicDataCreate.author())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        var course = courseRepository.findById(topicDataCreate.course())
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        var title = topicDataCreate.title();
        var message = topicDataCreate.message();
        var creationDate = LocalDateTime.now();

        if (topicRepository.existsByTitleIgnoreCase(title) && topicRepository.existsByMessageIgnoreCase(message)) {
            throw new IllegalArgumentException("Topic already exists");
        }

        var topic = new Topic(null, title, message, creationDate, Status.OPEN, user, course);
        topicRepository.save(topic);
        return new TopicDataDisplay(topic);
    }

    public TopicDataDisplay updateTopic(Long id, TopicDataUpdate topicDataUpdate) {

        var topic = topicRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Topic not found"));
        var author = userRepository.findById(topicDataUpdate.author())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        var course = courseRepository.findById(topicDataUpdate.course())
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        topic.setTitle(topicDataUpdate.title());
        topic.setMessage(topicDataUpdate.message());
        topic.setStatus(topicDataUpdate.status());
        topic.setAuthor(author);
        topic.setCourse(course);

        return new TopicDataDisplay(topic);
    }


    public void deleteTopic(Long id) {
        var topic = topicRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Topic not found"));
        topicRepository.delete(topic);
    }
}
