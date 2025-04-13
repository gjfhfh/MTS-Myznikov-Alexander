package main_package.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import main_package.request.CourseCreateRequest;
import main_package.response.CourseGetResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Course API", description = "Управление курсами")
public interface CourseController {
    @Operation(summary = "Получить курсы по ID")
    @ApiResponse(responseCode = "200", description = "Курсы найдены")
    public ResponseEntity<List<CourseGetResponse>> getAllCoursesById(@Parameter(name = "ID пользователя") Long userId);

    @Operation(summary = "Добавить курсы по ID")
    @ApiResponse(responseCode = "201", description = "Курсы добавлены")
    public ResponseEntity<Void> addCourseForUserById(@Parameter (name = "ID пользователя") Long userId, @Parameter (name = "DTO курса") CourseCreateRequest course);
}
