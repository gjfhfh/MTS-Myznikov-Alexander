package main_package.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import main_package.request.BookCreateRequest;
import main_package.response.BookGetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "Book API", description = "Управление книгами")
public interface BookController {
    @Operation(summary = "Получить книгу по ID")
    @ApiResponse(responseCode = "200", description = "Книга найдена")
    public ResponseEntity<List<BookGetResponse>> getAllBooksById(@Parameter (name = "ID пользователя", description = "ID пользователя") Long userId);

    @Operation(summary = "Добавить книгу по ID")
    @ApiResponse(responseCode = "201", description = "Книга добавлена")
    public ResponseEntity<Void> addBookForUserById(@Parameter (name = "ID пользователя") Long userId, @Parameter (name = "DTO книги")  BookCreateRequest book);
}
