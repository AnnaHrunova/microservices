package lv.item.model;

import java.util.List;

public class UserWithItem {

    private User user;

    private List<Item> items;

    public UserWithItem() {
    }

    public UserWithItem(User user, List<Item> item) {
        this.user = user;
        this.items = item;
    }


    public UserWithItem(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
