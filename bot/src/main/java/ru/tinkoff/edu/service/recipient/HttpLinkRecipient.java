package ru.tinkoff.edu.service.recipient;

import ru.tinkoff.edu.bot.logic.Bot;
import ru.tinkoff.edu.scrapperlink.dto.request.LinkUpdate;

public class HttpLinkRecipient extends UpdateRecipient {
    public HttpLinkRecipient(Bot bot) {
        super(bot);
    }

    @Override
    public void recieveUpdate(LinkUpdate request) {
        this.sendUpdates(request);
    }

}
