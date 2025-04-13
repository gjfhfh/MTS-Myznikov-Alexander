package main_package.model;

import java.util.ArrayList;

public record User(Long id, UserData fullName, UniversityData university, ArrayList<CourseData> courses, ArrayList<BookData> books) {}
