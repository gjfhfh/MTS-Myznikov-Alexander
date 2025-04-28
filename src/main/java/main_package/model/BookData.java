package main_package.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class BookData {
    @NotNull
    private String title;
    @NotNull
    private String author;
    @NotNull
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookData bookData = (BookData) o;
        return year == bookData.year && Objects.equals(title, bookData.title) && Objects.equals(author, bookData.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
