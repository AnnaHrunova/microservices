package lv.item.feign;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lv.item.model.Item;

@Component
public class ItemsAppFallback implements ItemsAppClient {

    @Override
    public List<Item> getAllItems() {
        List<Item> dummyUsers = new ArrayList<>();
        dummyUsers.add(new Item("dummy", "00"));
        return dummyUsers;
    }

    @Override
    public List<Item> createItems(List<Item> i) {
        List<Item> dummyItems = new ArrayList<>();
        Item dummyItem = new Item();
        dummyItem.setId("dummyItemId");
        dummyItem.setName("dummyItemName");
        dummyItem.setUserId("dummyUserId");
        dummyItems.add(dummyItem);
        return dummyItems;
    }

    @Override
    public List<Item> getItemsByUserId(String userId) {
        List<Item> dummyItems = new ArrayList<>();
        Item dummyItem = new Item("dummy item", "dummyUserId");
        dummyItem.setId("dummyId");
        dummyItems.add(dummyItem);
        return dummyItems;    }
}
