package ru.tinkoff.edu.bot.commands;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import java.net.URI;
import lombok.AllArgsConstructor;
import ru.tinkoff.edu.scrapperlink.client.ScrapperClient;
import ru.tinkoff.edu.scrapperlink.dto.request.RemoveLinkRequest;


@AllArgsConstructor
public class UntrackCommand implements CommandInfo {
    private final ScrapperClient client;
    private static final String UNTRACK_MESSAGE = "Send the link as a reply to remove this from tracking list";
    private static final String UNTRACK_DESCRIPTION = "Remove links from track";
    private static final String UNTRACK_OK  = "Link was successfully removed from tracking list";
    private static final String UNTRACK_ERRORNOTTRACEABLE = "link not tracked";

    @Override
    public String command() {
        return "/untrack";
    }

    @Override
    public String description() {
        return UNTRACK_DESCRIPTION;
    }

    @Override
    public SendMessage handle(Update update) {
        return supports(update) ? new SendMessage(update.message().chat().id(), UNTRACK_MESSAGE)
            : handleReply(update);
    }

    private SendMessage handleReply(Update update) {
        Message msg = update.message();
        Long chatId = msg.chat().id();
        try {
            client.deleteLink(chatId, new RemoveLinkRequest(URI.create(msg.text())));
        } catch (RuntimeException ex) {
            return new SendMessage(chatId, UNTRACK_ERRORNOTTRACEABLE);
        }
        return new SendMessage(chatId, UNTRACK_OK);
    }
}
