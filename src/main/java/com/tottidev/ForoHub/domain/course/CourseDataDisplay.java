package com.tottidev.ForoHub.domain.course;

public record CourseDataDisplay(
        Long id,
        String name,
        String category
) {

    public CourseDataDisplay(Course course) {
        this(course.getId(), course.getName(), course.getCategory());
    }

}
