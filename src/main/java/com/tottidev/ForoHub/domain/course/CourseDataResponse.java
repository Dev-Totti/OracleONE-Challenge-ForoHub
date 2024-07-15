package com.tottidev.ForoHub.domain.course;

public record CourseDataResponse(
        Long id,
        String name,
        String category
) {
    public CourseDataResponse(Course course) {
        this(course.getId(), course.getName(), course.getCategory());
    }
}
