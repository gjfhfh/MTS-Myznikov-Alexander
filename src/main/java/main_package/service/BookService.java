package main_package.service;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import main_package.model.BookData;
import main_package.repository.BookRepository;
import main_package.request.BookCreateRequest;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Long createBook(BookCreateRequest request) {
        log.info("Adding new book {} by {}", request.title(), request.author());
        Long courseId = bookRepository.createBook(new BookData(request.title(), request.author(), request.year()));
        log.info("Created new book with id: {}", courseId);
        return courseId;
    }

    public ArrayList<BookData> getAllBooksById(Long userId) {
        log.info("Getting all books by id: {}", userId);
        ArrayList<BookData> books = bookRepository.getAllBooksById(userId);
        log.info("Found books:");
        for (BookData book : books) {
            log.info("{} - {}; ", book.title(), book.author());
        }
        return books;
    }
}
