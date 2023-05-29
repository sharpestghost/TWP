package ru.tinkoff.edu.bot.commands;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import java.net.URI;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import ru.tinkoff.edu.scrapperlink.client.ScrapperClient;
import ru.tinkoff.edu.scrapperlink.dto.response.LinkResponse;

@AllArgsConstructor
public class ListCommand implements CommandInfo {
    private final ScrapperClient client;
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
        Message msg = update.message();
        Long chatId = msg.chat().id();
        Set<URI> resp = Arrays.stream(client.getLinks(chatId).links()).map(LinkResponse::url)
            .collect(Collectors.toSet());
        StringBuilder linksStringBuilder = new StringBuilder(!resp.isEmpty() ? LIST_MESSAGE : SPECIAL_MESSAGE);
        for (URI link : resp) {
            linksStringBuilder.append("\n").append(link.toString());
        }
        return new SendMessage(chatId, supports(update) ? linksStringBuilder.toString() : STANDARD_ERROR_MSG);
    }
}
