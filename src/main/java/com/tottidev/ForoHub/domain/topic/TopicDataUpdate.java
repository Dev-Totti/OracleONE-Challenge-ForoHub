package com.tottidev.ForoHub.domain.topic;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicDataUpdate(
        @NotBlank
        String title,

        @NotBlank
        String message,

        @Enumerated(EnumType.STRING)
        Status status,

        @NotNull
        Long author,

        @NotNull
        Long course
) {
}
