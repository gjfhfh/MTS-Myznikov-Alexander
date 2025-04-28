package main_package.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import main_package.model.User;
import main_package.request.UserCreateRequest;
import main_package.response.UniversityGetResponse;
import main_package.response.UserGetResponse;
import org.springframework.http.ResponseEntity;

@Tag(name = "User API", description = "Управление пользователями")
public interface UserController {
    @Operation(summary = "Получить университет по ID")
    @ApiResponse(responseCode = "200", description = "Университет найден")
    public ResponseEntity<UniversityGetResponse> getUniversityById(@Parameter (name = "ID пользователя", description = "ID пользователя") Long userId);


    @Operation(summary = "Создать пользователя")
    @ApiResponse(responseCode = "200", description = "Пользователь создан")
    public ResponseEntity<User> createUser(UserCreateRequest request);

    @Operation(summary = "Получить пользователя по ID")
    @ApiResponse(responseCode = "200", description = "Пользователь найден")
    public ResponseEntity<UserGetResponse> getUser(@Parameter(name = "ID пользователя", description = "ID пользователя") Long userId);
}
