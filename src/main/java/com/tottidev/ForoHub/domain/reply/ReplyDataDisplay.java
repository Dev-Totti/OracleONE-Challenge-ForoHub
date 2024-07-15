package com.tottidev.ForoHub.domain.reply;

import java.time.LocalDateTime;

public record ReplyDataDisplay(
        Long id,
        String message,
        LocalDateTime created,
        Long topic,
        Long author
) {
    public ReplyDataDisplay(Reply reply) {
        this(reply.getId(), reply.getMessage(), reply.getCreated(), reply.getTopic().getId(), reply.getAuthor().getId());
    }
}
