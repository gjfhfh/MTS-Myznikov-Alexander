package main_package.service;

import java.util.ArrayList;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main_package.model.University;
import main_package.model.UniversityData;
import main_package.repository.UniversityRepository;
import main_package.request.UniversityCreateRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityData createUniversity(UniversityCreateRequest request) {
        log.info("Adding new university {} {}", request.name(), request.location());
        University university = new University(new UniversityData(request.name(), request.location()));
        universityRepository.save(university);
        return university.getUniversityData();
    }
}
