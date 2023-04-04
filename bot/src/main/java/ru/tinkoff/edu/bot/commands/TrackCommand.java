package ru.tinkoff.edu.bot.commands;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class TrackCommand implements CommandInfo {

    private static String TRACK_MESSAGE = "Send the link as a reply to add this to tracking list";
    private static String TRACK_DESCRIPTION = "Add links to track";
    private static String replyMessage = "Link was successfully add to tracking list";
    @Override
    public String command() {
        return "/track";
    }

    private boolean isReply(Update update) {
        Message reply = update.message().replyToMessage();
        return reply != null && reply.text().equals(TRACK_MESSAGE);
    }

    @Override
    public String description() {
        return TRACK_DESCRIPTION;
    }

    @Override
    public SendMessage handle(Update update) {
        return isReply(update) ? handleReply(update) : new SendMessage(update.message().chat().id(), TRACK_DESCRIPTION);
    }

    private SendMessage handleReply(Update update) {
        Long chatId = update.message().chat().id();
        //get link here
        try {
            //add link to list here
        }  catch (RuntimeException ex) {
            replyMessage = STANDARD_ERROR_MSG;
        }

        return new SendMessage(chatId, replyMessage);
    }
}
