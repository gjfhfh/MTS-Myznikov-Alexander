package main_package.repository;

import main_package.model.Course;
import main_package.model.CourseData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class InMemoryCourseRepository implements CourseRepository{

    CourseData course1 = new CourseData("Java");
    CourseData course2 = new CourseData("Квадроберство");
    CourseData course3 = new CourseData("Подсчет манулов");
    ArrayList<CourseData> allCourses = new ArrayList<>();

    @Override
    public ArrayList<CourseData> getAllCoursesById(Long id) {
        allCourses.add(course1);
        allCourses.add(course2);
        allCourses.add(course3);
        return allCourses;
    }

    @Override
    public Long createCourse(CourseData courseData) {
        Course course = new Course(52L, courseData);
        return 52L;
    }
}
