package lv.item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lv.commands.CreateItemCommand;
import lv.commands.CreateItemResult;
import lv.handlers.CommandExecutor;

@RefreshScope
@RestController
@RequestMapping("items")
public class ItemsController {

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private CommandExecutor commandExecutor;

    @Value("${message:Hello default}")
    private String message;

    @Value("${server.port}")
    private String serverPort;

    @GET
    @CrossOrigin(origins = {"http://localhost:63342", "http://localhost:8089"})
    @RequestMapping("/all")
    public List<Item> getItems() {
        return itemsRepository.findAll().stream()
                .peek(i -> {
                    i.setCurrentPort(serverPort); i.setMessage(message);
                })
                .collect(Collectors.toList());
    }

    @GET
    @CrossOrigin(origins = {"http://localhost:63342", "http://localhost:8089"})
    @RequestMapping("/user/{userId}")
    public List<Item> getItemsByUserId(@PathVariable String userId) {
        return itemsRepository.findByUserId(userId).stream()
                .peek(i -> {
                    i.setCurrentPort(serverPort); i.setMessage(message);
                })
                .collect(Collectors.toList());
    }

    @POST
    @RequestMapping(value = "/create", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public List<Item> createItems(@RequestBody List<Item> items) {
        return items.stream()
                    .map(this::getResultItem)
                    .collect(Collectors.toList());
    }

    private Item getResultItem(Item i) {
        CreateItemCommand createItemCommand = new CreateItemCommand(i.getName(), i.getUserId(), serverPort, message);
        CreateItemResult result = commandExecutor.execute(createItemCommand);
        return result.getItem();
    }
}
