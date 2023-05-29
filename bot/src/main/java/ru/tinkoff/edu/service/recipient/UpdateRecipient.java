package ru.tinkoff.edu.service.recipient;

import com.pengrad.telegrambot.request.SendMessage;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import ru.tinkoff.edu.bot.logic.Bot;
import ru.tinkoff.edu.scrapperlink.dto.request.LinkUpdate;

@AllArgsConstructor
public abstract class UpdateRecipient {
    private Bot bot;

    public abstract void recieveUpdate(LinkUpdate request);

    protected void sendUpdates(LinkUpdate request) {
        Arrays.stream(request.tgChatIds())
            .forEach(id -> bot.sendMessage(new SendMessage(id,
                request.url() + "\n" + request.description())));
    }
}
