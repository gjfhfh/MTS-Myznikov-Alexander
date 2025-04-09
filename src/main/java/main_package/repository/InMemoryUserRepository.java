package main_package.repository;

import main_package.exception.UserNotFoundException;
import main_package.model.User;
import main_package.model.UserData;
import org.springframework.stereotype.Repository;

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
    public Long createUser(UserData fullName) {
        User user = new User(52L, fullName, null, null, null);
        return 52L;
    }
}
