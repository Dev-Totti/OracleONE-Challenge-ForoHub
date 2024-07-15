package com.tottidev.ForoHub.domain.course;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "courses")
@Entity(name = "Course")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private boolean active = true;

    public Course(CourseDataRegister courseDataRegister) {
        this.name = courseDataRegister.name();
        this.category = courseDataRegister.category();
    }

    public void update(CourseDataUpdate courseDataUpdate) {
        if (courseDataUpdate.name() != null) {
            this.name = courseDataUpdate.name();
        }

        if (courseDataUpdate.category() != null) {
            this.category = courseDataUpdate.category();
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
