package main_package.repository;

import main_package.exception.BooksNotFoundException;
import main_package.model.Book;
import main_package.model.BookData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;

@Repository
public class InMemoryBookRepository implements BookRepository {

    BookData book1 = new BookData("Drive", "James Sallis", 2005);
    BookData book2 = new BookData("Murder on the Orient Express", "Agatha Christie", 1934);
    BookData book3 = new BookData("Fight Club", "Chuck Palahniuk", 1996);

    ArrayList<BookData> allBooks = new ArrayList<>(Arrays.asList(book1, book2, book3));

    @Override
    public ArrayList<BookData> getAllBooksById(Long id) {
        if (allBooks.isEmpty()) throw new BooksNotFoundException();
        return allBooks;
    }

    @Override
    public Long createBook(BookData bookData) {
        Book book = new Book(52L, bookData);
        return 52L;
    }
}
