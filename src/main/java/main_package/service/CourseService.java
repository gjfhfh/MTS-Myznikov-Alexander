package main_package.service;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import main_package.model.CourseData;
import main_package.repository.CourseRepository;
import main_package.request.CourseCreateRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Long createCourse(CourseCreateRequest request) {
        log.info("Adding new course {}", request.name());
        Long courseId = courseRepository.createCourse(new CourseData(request.name()));
        log.info("Created new course with id: {}", courseId);
        return courseId;
    }

    public ArrayList<CourseData> getAllCoursesById(Long userId) {
        log.info("Getting all courses by id: {}", userId);
        ArrayList<CourseData> courses = courseRepository.getAllCoursesById(userId);
        log.info("Found courses:");
        for (int i = 0; i < courses.size(); i++) {
            log.info("{}; ", courses.get(i).name());
        }
        return courses;
    }
}
