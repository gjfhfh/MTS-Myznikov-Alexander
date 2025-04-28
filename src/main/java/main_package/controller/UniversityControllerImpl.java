package main_package.controller;

import lombok.RequiredArgsConstructor;
import main_package.model.UniversityData;
import main_package.request.UniversityCreateRequest;
import main_package.response.UniversityGetResponse;
import main_package.service.UniversityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/university")
@RequiredArgsConstructor
public class UniversityControllerImpl implements UniversityController{

    private final UniversityService universityService;

    @PutMapping("/creation")
    public ResponseEntity<UniversityData> addUniversity(@RequestBody UniversityCreateRequest university) {
        UniversityData universityData = universityService.createUniversity(university);
        return ResponseEntity.status(HttpStatus.CREATED).body(universityData);
    }
}
