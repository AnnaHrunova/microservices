package lv.item.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lv.item.model.Item;

@FeignClient(name = "app-items", fallback = ItemsAppFallback.class)
public interface ItemsAppClient {

    @GetMapping(value = "/items/all")
    List<Item> getAllItems();

    @GetMapping(value = "/items/create")
    List<Item> createItems(List<Item> i);

    @GetMapping("/items/user/{userId}")
    List<Item> getItemsByUserId(@PathVariable("userId") String userId);
}
