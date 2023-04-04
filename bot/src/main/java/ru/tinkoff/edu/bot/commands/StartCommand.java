package ru.tinkoff.edu.bot.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class StartCommand implements CommandInfo {

    private static String START_MESSAGE = "Enter your username";
    private static String START_DESCRIPTION = "User registration for link tracking";
    @Override
    public String command() {
        return "/start";
    }

    @Override
    public String description() {
        return START_DESCRIPTION;
    }

    @Override
    public SendMessage handle(Update update) {
        return new SendMessage(update.message().chat().id(), START_MESSAGE);
    }
}
