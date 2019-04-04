package lv.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.commands.CreateItemCommand;
import lv.commands.CreateItemResult;
import lv.item.Item;
import lv.item.ItemsRepository;

@Component
public class CreateItemHandler implements DomainCommandHandler<CreateItemCommand, CreateItemResult> {

    @Autowired
    private ItemsRepository itemsRepository;

    @Override
    public CreateItemResult execute(CreateItemCommand command) {
        Item item = new Item();
        item.setName(command.getName());
        item.setUserId(command.getUserId());
        item.setCurrentPort(command.getCurrentPort());
        item.setMessage(command.getMessage());
        return new CreateItemResult(itemsRepository.save(item));
    }

    @Override
    public Class getCommandType() {
        return CreateItemCommand.class;
    }
}
