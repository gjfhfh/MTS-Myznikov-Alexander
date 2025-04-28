package main_package.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main_package.exception.UniversityNotFoundException;
import main_package.exception.UserNotFoundException;
import main_package.model.University;
import main_package.model.UniversityData;
import main_package.model.User;
import main_package.repository.UniversityRepository;
import main_package.repository.UserRepository;
import main_package.request.UserCreateRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UniversityRepository universityRepository;

    public User createUser (UserCreateRequest request) {
        log.info("Creating new user with username: {} {}", request.name(), request.surname());
        University university = universityRepository.findById(request.universityId()).orElseThrow(UniversityNotFoundException::new);
        User user = new User(request.name() + request.surname(), university);
        userRepository.save(user);
        return user;
    }

    public User getUserById(Long userId) {
        log.info("Getting user by id: {}", userId);
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        log.info("Found user: {}", user.getFullName());
        return user;
    }

    @Async
    public CompletableFuture<User> getUserByIdAsync(Long userId) {
        log.info("Asynchronously getting user by id: {}", userId);
        User user = getUserById(userId);
        return CompletableFuture.completedFuture(user);
    }

    public UniversityData getUniversityById(Long userId) {
        log.info("Getting university by id: {}", userId);
        University university = userRepository.findById(userId).orElseThrow(UniversityNotFoundException::new).getUniversity();
        log.info("Found university: {}", university.getUniversityData().getName());
        return university.getUniversityData();
    }
}
