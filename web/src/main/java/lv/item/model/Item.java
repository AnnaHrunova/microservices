package lv.item.model;

import org.springframework.data.annotation.Id;

public class Item {

    @Id
    private String id;

    private String name;

    private String userId;

    private String currentPort;

    private String message;

    public Item() {
    }

    public Item(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public Item(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCurrentPort() {
        return currentPort;
    }

    public void setCurrentPort(String currentPort) {
        this.currentPort = currentPort;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
