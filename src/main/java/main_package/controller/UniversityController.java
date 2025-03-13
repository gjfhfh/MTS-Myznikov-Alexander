package main_package.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import main_package.request.UniversityCreateRequest;
import main_package.response.UniversityGetResponse;
import org.springframework.http.ResponseEntity;

@Tag(name = "University API", description = "Управление университетами")
public interface UniversityController {
    @Operation(summary = "Получить университет по ID")
    @ApiResponse(responseCode = "200", description = "Университет найден")
    public ResponseEntity<UniversityGetResponse> getUniversityById(@Parameter (name = "ID пользователя", description = "ID пользователя") Long userId);

    @Operation(summary = "Добавить университет по ID")
    @ApiResponse(responseCode = "201", description = "Университет найден")
    public ResponseEntity<Void> addUniversityForUserById(@Parameter(name = "ID пользователя") Long userId, @Parameter (name = "DTO университета") UniversityCreateRequest university);
}
