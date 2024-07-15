package com.tottidev.ForoHub.domain.course;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "courses")
@Entity(name = "Course")
@Getter
@Setter
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
}
