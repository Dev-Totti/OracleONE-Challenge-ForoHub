package com.tottidev.ForoHub.domain.course;

import jakarta.validation.constraints.NotBlank;

public record CourseDataRegister(
        @NotBlank
        String name,

        @NotBlank
        String category
) {
}
