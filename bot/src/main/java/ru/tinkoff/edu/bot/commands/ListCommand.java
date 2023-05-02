package ru.tinkoff.edu.bot.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import ru.tinkoff.edu.dto.response.LinkResponse;
import ru.tinkoff.edu.dto.response.ListLinksResponse;

public class ListCommand implements CommandInfo {
    private static final String LIST_MESSAGE = "Current list of tracking links:";
    private static final String LIST_DESCRIPTION = "Provide a list of tracking lists.";
    private static final String SPECIAL_MESSAGE = "Tracking list is empty.";

    @Override
    public String command() {
        return "/list";
    }

    @Override
    public String description() {
        return LIST_DESCRIPTION;
    }

    @Override
    public SendMessage handle(Update update) {
        Long chatId = update.message().chat().id();
        ListLinksResponse response = new ListLinksResponse(null, 0);
        try {
            //get tracking links
        } catch (RuntimeException ex) {
            return new SendMessage(chatId, STANDARD_ERROR_MSG);
        }
        StringBuilder linksStringBuilder = new StringBuilder(response.size() != 0 ?
                LIST_MESSAGE : SPECIAL_MESSAGE);

        for (LinkResponse linkResponse : response.links())
            linksStringBuilder.append("\n").append(linkResponse.url().toString());
        return new SendMessage(chatId, linksStringBuilder.toString());
    }
}
