package main_package.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import main_package.request.UserCreateRequest;
import main_package.response.UserGetResponse;
import org.springframework.http.ResponseEntity;

@Tag(name = "User API", description = "Управление пользователями")
public interface UserController {
    @Operation(summary = "Создать пользователя")
    @ApiResponse(responseCode = "200", description = "Пользователь создан")
    public ResponseEntity<Long> createUser(UserCreateRequest request);

    @Operation(summary = "Получить пользователя по ID")
    @ApiResponse(responseCode = "200", description = "Пользователь найден")
    public ResponseEntity<UserGetResponse> getUser(@Parameter(name = "ID пользователя", description = "ID пользователя") Long userId);
}
