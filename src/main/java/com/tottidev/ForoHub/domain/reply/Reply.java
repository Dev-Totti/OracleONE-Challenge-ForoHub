package com.tottidev.ForoHub.domain.reply;

import com.tottidev.ForoHub.domain.topic.Topic;
import com.tottidev.ForoHub.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "replies")
@Entity(name = "Reply")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private LocalDateTime created;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "topic")
    private Topic topic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author")
    private User author;

    public Reply(String message, User author, Topic topic) {
        this.message = message;
        this.author = author;
        this.topic = topic;
        this.created = LocalDateTime.now();
    }
}
