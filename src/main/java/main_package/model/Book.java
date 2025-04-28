package main_package.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name="books")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Embedded
    private BookData bookData;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Book(BookData bookData, User user) {
        this.bookData = bookData;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookData, book.bookData) && Objects.equals(user, book.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookData, user);
    }
}
