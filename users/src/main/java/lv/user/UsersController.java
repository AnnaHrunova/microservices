package lv.user;

import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UsersRepositiry usersRepositiry;

    @Value("${message:Hello default}")
    private String message;

    @Value("${server.port}")
    private String serverPort;

    @GET
    @RequestMapping("/all")
    @CrossOrigin(origins = "http://localhost:8089")
    public List<User> getUsers() {
        return usersRepositiry.findAll().stream()
                .peek(u -> {u.setCurrentPort(serverPort); u.setMessage(message);})
                .collect(Collectors.toList());
    }

    @POST
    @CrossOrigin(origins = "http://localhost:8089")
    @RequestMapping(value = "/create", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public User createUser(@RequestBody User user) {
        User u = usersRepositiry.save(user);
        u.setMessage(message);
        u.setCurrentPort(serverPort);
        return u;
    }
}
