package main_package.service;

import lombok.extern.slf4j.Slf4j;
import main_package.model.UserData;
import main_package.repository.UserRepository;
import main_package.request.UserCreateRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long createUser (UserCreateRequest request) {
        log.info("Creating new user with username: {} {}", request.name(), request.surname());
        Long userId = userRepository.createUser (new UserData(request.name(), request.surname(), request.year()));
        log.info("Created new user with id: {}", userId);
        return userId;
    }

    public UserData getUserById(Long userId) {
        log.info("Getting user by id: {}", userId);
        UserData user = userRepository.getUserDataById(userId);
        log.info("Found user: {} {}", user.name(), user.surname());
        return user;
    }

    @Async
    public CompletableFuture<UserData> getUserByIdAsync(Long userId) {
        log.info("Asynchronously getting user by id: {}", userId);
        UserData user = getUserById(userId);
        return CompletableFuture.completedFuture(user);
    }

    public synchronized Long createUserExactlyOnce(UserCreateRequest request) {
        log.info("Creating user exactly once with username: {} {}", request.name(), request.surname());

        Long userId = userRepository.createUser (new UserData(request.name(), request.surname(), request.year()));

        log.info("Created user exactly once with id: {}", userId);
        return userId;
    }
}
