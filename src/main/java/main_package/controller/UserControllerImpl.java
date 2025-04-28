package main_package.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import main_package.model.UniversityData;
import main_package.model.User;
import main_package.request.UserCreateRequest;
import main_package.response.UniversityGetResponse;
import main_package.response.UserGetResponse;
import main_package.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
    }

    @CircuitBreaker(name = "apiCircuitBreaker")
    @GetMapping("/{userId}")
    public ResponseEntity<UserGetResponse> getUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(new UserGetResponse(user.getFullName(),user.getUniversity()));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UniversityGetResponse> getUniversityById(@PathVariable Long userId) {
        UniversityData universityData = userService.getUniversityById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(new UniversityGetResponse(universityData.getName(), universityData.getLocation()));
    }
}
