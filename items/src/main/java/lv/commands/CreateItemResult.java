package lv.commands;

import lv.item.Item;

public class CreateItemResult implements DomainCommandResult {

    private Item item;

    public CreateItemResult(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
