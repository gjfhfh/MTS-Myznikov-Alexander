package main_package.controller;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import main_package.request.BookCreateRequest;
import main_package.response.BookGetResponse;
import main_package.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    @RateLimiter(name = "apiRateLimiter")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookGetResponse>> getAllBooksById(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooksById(userId).stream()
                .map(bookData -> new BookGetResponse(bookData.getBookData().getTitle(), bookData.getBookData().getAuthor(), bookData.getBookData().getYear()))
                .collect(Collectors.toList()));
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<Void> addBookForUserById(
            @PathVariable Long userId, @RequestBody BookCreateRequest book) {
        bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
