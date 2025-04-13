package main_package.repository;

import main_package.exception.UserNotFoundException;
import main_package.model.User;
import main_package.model.UserData;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;

@Repository
public class InMemoryUserRepository implements UserRepository {

    public HashMap<Long, UserData> userData = new HashMap<>() {{
        put(1L, new UserData("Александр", "Мызников", 2006));
    }};

    @Override
    public UserData getUserDataById(Long id) {
        if (!userData.containsKey(id)) throw new UserNotFoundException();
        return userData.get(id);
    }

    @Override
    public Long createUser (UserData fullName) {
        User user = new User(52L, fullName, null, null, null);
        return 52L;
    }

    public String fetchRandomUser () {
        WebClient webClient = WebClient.create();
        return webClient.get()
                .uri("https://random-data-api.com/api/users/random_user")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
