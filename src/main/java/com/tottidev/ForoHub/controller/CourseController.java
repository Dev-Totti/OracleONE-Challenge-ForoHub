package com.tottidev.ForoHub.controller;

import com.tottidev.ForoHub.domain.course.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> createCourse(@RequestBody @Valid CourseDataRegister courseDataRegister, UriComponentsBuilder uriComponentsBuilder) {
        Course course = courseRepository.save(new Course(courseDataRegister));
        CourseDataResponse courseDataResponse = new CourseDataResponse(course);
        URI url = uriComponentsBuilder.path("/course/{id}").buildAndExpand(course.getId()).toUri();

        return ResponseEntity.created(url).body(courseDataResponse);

    }

    @GetMapping
    public ResponseEntity<Page<CourseDataDisplay>> getCourses(Pageable pageable) {
        return ResponseEntity.ok(courseRepository.findByActiveTrue(pageable).map(CourseDataDisplay::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> updateCourse(@RequestBody @Valid CourseDataUpdate courseDataUpdate) {
        Course course = courseRepository.getReferenceById(courseDataUpdate.id());
        course.update(courseDataUpdate);
        return ResponseEntity.ok(new CourseDataDisplay(course));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        Course course = courseRepository.getReferenceById(id);
        course.setActive(false);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDataDisplay> getCourse(@PathVariable Long id) {
        Course course = courseRepository.getReferenceById(id);
        return ResponseEntity.ok(new CourseDataDisplay(course));
    }

}
