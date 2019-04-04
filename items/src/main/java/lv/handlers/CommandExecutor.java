package lv.handlers;

import lv.commands.DomainCommand;
import lv.commands.DomainCommandResult;

public interface CommandExecutor {

    <T extends DomainCommandResult> T execute(DomainCommand<T> domainCommand);

}
