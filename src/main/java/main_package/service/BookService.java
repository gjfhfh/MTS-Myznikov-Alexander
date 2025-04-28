package main_package.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main_package.exception.UserNotFoundException;
import main_package.model.Book;
import main_package.model.BookData;
import main_package.model.User;
import main_package.repository.BookRepository;
import main_package.repository.UserRepository;
import main_package.request.BookCreateRequest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public Book createBook(BookCreateRequest request) {
        log.info("Adding new book {} by {}", request.title(), request.author());
        User user = userRepository.findById(request.userId()).orElseThrow(UserNotFoundException::new);
        Book book = new Book(new BookData(request.title(), request.author(), request.year()), user);
        bookRepository.save(book);
        return book;
    }

    @Cacheable(value = "books", key = "#userId")
    public List<Book> getAllBooksById(Long userId) {
        log.info("Getting all books by id: {}", userId);
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        log.info("Successfully handled request for userId {}", userId);
        return user.getBooks();
    }
}
