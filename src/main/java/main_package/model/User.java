package main_package.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String fullName;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private University university;
    @NotNull
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public User(String fullName, University university) {
        this.fullName = fullName;
        this.university = university;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(fullName, user.fullName) && Objects.equals(university, user.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, university);
    }
}
