package lv.item.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import lv.item.model.User;

@FeignClient(name = "app-users", fallback = UsersAppFallback.class)
public interface UsersAppClient {

    @GetMapping(value = "/users/all")
    List<User> getAllUsers();

    @GetMapping(value = "/users/create")
    User createUser(User u);
}
