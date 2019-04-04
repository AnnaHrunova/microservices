package lv.item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lv.item.feign.ItemsAppClient;
import lv.item.feign.UsersAppClient;
import lv.item.model.Item;
import lv.item.model.User;
import lv.item.model.UserWithItem;

@RefreshScope
@RestController
@EnableDiscoveryClient
@EnableFeignClients
class ClientRegistryController {

    private final UsersAppClient usersAppClient;

    private final ItemsAppClient itemsAppClient;

    public ClientRegistryController(UsersAppClient usersAppClient,
                                    ItemsAppClient itemsAppClient) {
        this.usersAppClient = usersAppClient;
        this.itemsAppClient = itemsAppClient;
    }

    @Value("${message:Hello default}")
    private String message;

    private static final Logger log = LoggerFactory.getLogger(ClientRegistryController.class);

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping("/users/all")
    List<User> getAllUsers() {
        return usersAppClient.getAllUsers();
    }

    @POST
    @CrossOrigin(origins = {"http://localhost:63342", "http://localhost:8089"})
    @RequestMapping(value = "/create-user-with-items", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public UserWithItem createUserWithItems(@RequestBody UserWithItem userWithItem) {
        User savedUser = usersAppClient.createUser(userWithItem.getUser());
        List<Item> savedItems = savedUserItems(userWithItem.getItems(), savedUser.getId());
        return new UserWithItem(savedUser, savedItems);
    }

    @POST
    @CrossOrigin(origins = {"http://localhost:63342", "http://localhost:8089"})
    @RequestMapping(value = "/create-user", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public User createUser(@RequestBody User user) {
        return usersAppClient.createUser(user);
    }

    @GET
    @CrossOrigin(origins = {"http://localhost:63342", "http://localhost:8089"})
    @RequestMapping(value = "/get-users-with-items", produces = MediaType.APPLICATION_JSON)
    public List<UserWithItem> getUsersWithItems() {
        return usersAppClient.getAllUsers().stream()
                             .map(this::createUserWithItem)
                             .collect(Collectors.toList());
    }

    @GET
    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(value = "/items/all", produces = MediaType.APPLICATION_JSON)
    public List<Item> getAllItems() {
        return itemsAppClient.getAllItems();
    }

    private List<Item> savedUserItems(List<Item> i, String userId) {
        List<Item> items = i.stream()
                .peek(i1 -> i1.setUserId(userId))
                .collect(Collectors.toList());
        return itemsAppClient.createItems(items);
    }

    private UserWithItem createUserWithItem(User u) {
        return new UserWithItem(u, itemsAppClient.getItemsByUserId(u.getId()));
    }
}
