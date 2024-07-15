package com.tottidev.ForoHub.domain.topic;

import java.time.LocalDateTime;

public record TopicDataDisplay(
        Long id,
        String title,
        String message,
        LocalDateTime created,
        Status status,
        Long author,
        Long course
) {

    public TopicDataDisplay(Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreated(),
                topic.getStatus(),
                topic.getAuthor().getId(),
                topic.getCourse().getId()
        );
    }
}
