package ru.tinkoff.edu.bot.commands;

import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public interface CommandInfo {
    String STANDARD_ERROR_MSG = "Something went wrong, please try again";

    String command();

    String description();

    SendMessage handle(Update update);

    default boolean supports(Update update) {
        String msg = update.message().text();
        return msg != null && msg.equals(command());
    }

    default BotCommand toApiCommand() {
        return new BotCommand(command(), description());
    }

}
