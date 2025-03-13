package main_package.repository;

import main_package.model.User;
import main_package.model.UserData;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryUserRepository implements UserRepository {

    public UserData userData = new UserData("Александр", "Мызников", 2006);

    @Override
    public UserData getUserDataById(Long id) {
        return userData;
    }

    @Override
    public Long createUser(UserData fullName) {
        User user = new User(52L, fullName, null, null, null);
        return 52L;
    }
}
