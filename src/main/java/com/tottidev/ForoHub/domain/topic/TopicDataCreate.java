package com.tottidev.ForoHub.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicDataCreate(
        @NotBlank
        String title,

        @NotBlank
        String message,

        @NotNull
        Long author,

        @NotNull
        Long course
) {
}
