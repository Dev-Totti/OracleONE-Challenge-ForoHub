package com.tottidev.ForoHub.domain.topic;

import com.tottidev.ForoHub.domain.course.CourseRepository;
import com.tottidev.ForoHub.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Topic createTopic(TopicData topicData) {

        var user = userRepository.findById(topicData.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        var course = courseRepository.findById(topicData.courseId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        var title = topicData.title();
        var message = topicData.message();
        var creationDate = topicData.creationDate();
        var status = topicData.status();

        if (topicRepository.existsByTitleIgnoreCase(title) && topicRepository.existsByMessageIgnoreCase(message)) {
            throw new IllegalArgumentException("Topic already exists");
        }

        var topic = new Topic(
                null,
                title,
                message,
                creationDate,
                status,
                user,
                course
        );

        topicRepository.save(topic);

        return topic;

    }

}
