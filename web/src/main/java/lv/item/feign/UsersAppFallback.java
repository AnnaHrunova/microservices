package lv.item.feign;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lv.item.model.User;

@Component
public class UsersAppFallback implements UsersAppClient {

    @Override
    public List<User> getAllUsers() {
        List<User> dummyUsers = new ArrayList<>();
        dummyUsers.add(new User("dummy", 00));
        return dummyUsers;
    }

    @Override
    public User createUser(User u) {
        User user = new User("dummy", 00);
        user.setId("dummyId");
        user.setCurrentPort("dummyPort");
        user.setMessage("dummyMessage");
        return user;
    }
}
