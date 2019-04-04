package lv.commands;

public class CreateItemCommand implements DomainCommand<CreateItemResult> {

    private String name;
    private String userId;
    private String currentPort;
    private String message;

    public CreateItemCommand(String name, String userId, String currentPort, String message) {
        this.name = name;
        this.userId = userId;
        this.currentPort = currentPort;
        this.message = message;
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
