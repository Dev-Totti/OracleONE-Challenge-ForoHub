package com.tottidev.ForoHub.domain.topic;

import com.tottidev.ForoHub.domain.course.Course;
import com.tottidev.ForoHub.domain.user.User;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String message;

    private LocalDateTime created;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course")
    private Course course;


    public Topic update(TopicDataUpdate topicDataUpdate) {
        return null;
    }
}
