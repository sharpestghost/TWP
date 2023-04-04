package ru.tinkoff.edu.bot.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class HelpCommand implements CommandInfo{

    private static String HELP_MESSAGE = "To get a list of commands, enter help.";
    private static String HELP_DESCRIPTION = "List of available commands.";
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
        return new SendMessage(update.message().chat().id(), HELP_MESSAGE);
    }
}
