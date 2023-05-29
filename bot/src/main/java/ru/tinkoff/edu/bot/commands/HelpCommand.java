package ru.tinkoff.edu.bot.commands;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import ru.tinkoff.edu.scrapperlink.client.ScrapperClient;

@AllArgsConstructor
public class HelpCommand implements CommandInfo {
    private final ScrapperClient client;
    private static final String HELP_MESSAGE = "To get a list of commands, enter help.";
    private static final String HELP_DESCRIPTION = "List of available commands.";

    @Override
    public String command() {
        return "/help";
    }

    @Override
    public String description() {
        return HELP_DESCRIPTION;
    }

    @Override
    public SendMessage handle(Update update) {
        Message msg = update.message();
        StringBuilder helpStringBuilder = new StringBuilder();
        if (supports(update)) {
            for (CommandInfo command : BotCommandsList.getCommands().values()) {
                helpStringBuilder.append(command.command() + "   " + command.description()).append("\n");
            }
        }
        return new SendMessage(msg.chat().id(), supports(update)
            ? helpStringBuilder.toString() : STANDARD_ERROR_MSG);
    }
}
