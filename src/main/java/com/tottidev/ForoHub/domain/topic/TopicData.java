package com.tottidev.ForoHub.domain.topic;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicData(
        @NotBlank
        String title,

        @NotBlank
        String message,

        @NotNull
        @Future
        LocalDateTime creationDate,

        @NotNull
        Status status,

        @NotNull
        Long userId,

        @NotNull
        Long courseId
) {
}
