package main_package.repository;

import main_package.model.University;
import main_package.model.UniversityData;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryUniversityRepository implements UniversityRepository {

    public UniversityData university = new UniversityData("MIPT", "Russia");

    @Override
    public UniversityData getUniversityById(Long id) {
        return university;
    }

    @Override
    public Long createUniversity(UniversityData universityData) {
        University university = new University(52L, universityData);
        return 52L;
    }
}
