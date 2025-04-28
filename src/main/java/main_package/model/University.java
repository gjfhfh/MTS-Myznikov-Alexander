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
@Table(name="universities")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Embedded
    private UniversityData universityData;
    @NotNull
    @OneToMany(mappedBy = "university", orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    public University(UniversityData universityData) {
        this.universityData = universityData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(universityData, that.universityData);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(universityData);
    }
}
