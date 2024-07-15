package com.tottidev.ForoHub.domain.course;

import jakarta.validation.constraints.NotNull;

public record CourseDataUpdate(
        @NotNull
        Long id,
        String name,
        String category
) {
}
