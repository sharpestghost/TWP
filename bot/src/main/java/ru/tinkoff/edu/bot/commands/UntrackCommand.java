package ru.tinkoff.edu.bot.commands;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class UntrackCommand implements CommandInfo {
    //Send the link as a reply to remove this from the tracking list
    private static final String UNTRACK_MESSAGE = "Send the link as a reply to add this to tracking list";
    private static final String UNTRACK_DESCRIPTION = "Remove links from track";
    private String replyMessage = "Link was successfully removed from tracking list";

    @Override
    public String command() {
        return "/untrack";
    }

    private boolean isReply(Update update) {
        Message reply = update.message().replyToMessage();
        return reply != null && reply.text().equals(UNTRACK_MESSAGE);
    }

    @Override
    public String description() {
        return UNTRACK_DESCRIPTION;
    }

    @Override
    public SendMessage handle(Update update) {
        return isReply(update) ? handleReply(update) : new SendMessage(update.message().chat().id(), UNTRACK_DESCRIPTION);
    }

    private SendMessage handleReply(Update update) {
        Long chatId = update.message().chat().id();
        //get link here
        try {
            //add link to list here
        } catch (RuntimeException ex) {
            replyMessage = STANDARD_ERROR_MSG;
        }

        return new SendMessage(chatId, replyMessage);
    }
}
