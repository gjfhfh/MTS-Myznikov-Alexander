package main_package.repository;

import main_package.model.BookData;

import java.util.ArrayList;

public interface BookRepository {
    ArrayList<BookData> getAllBooksById(Long id);
    Long createBook(BookData book);
}
