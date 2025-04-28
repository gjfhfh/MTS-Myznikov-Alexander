package main_package.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import main_package.model.UniversityData;
import main_package.request.UniversityCreateRequest;
import org.springframework.http.ResponseEntity;

@Tag(name = "University API", description = "Управление университетами")
public interface UniversityController {
    @Operation(summary = "Добавить университет")
    @ApiResponse(responseCode = "201", description = "Университет найден")
    public ResponseEntity<UniversityData> addUniversity(@Parameter (name = "DTO университета") UniversityCreateRequest university);
}
