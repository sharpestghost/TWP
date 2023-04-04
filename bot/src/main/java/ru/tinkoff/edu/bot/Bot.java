package ru.tinkoff.edu.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SetMyCommands;
import ru.tinkoff.edu.bot.commands.CommandInfo;

import java.util.List;

public class Bot {
    public final TelegramBot telegramBot;
    private final List<CommandInfo> supportedCommands;
    private static final String INVALID_COMMAND = "Invalid command option.";


    public Bot(String token, List<CommandInfo> supportedCommands) {
        this.telegramBot = new TelegramBot(token);
        this.supportedCommands = supportedCommands;
    }


    public void start() {
        BotCommand[] commands = new BotCommand[supportedCommands.size()];
        for (int i = 0; i < commands.length; i++) {
            commands[i] = supportedCommands.get(i).toApiCommand();
        }
        telegramBot.execute(new SetMyCommands(commands));
        telegramBot.setUpdatesListener(updates -> {
            for (Update update : updates)
                telegramBot.execute(processUpdate(update));

            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    public SendMessage processUpdate(Update update) {
        for (CommandInfo command : supportedCommands)
            if (command.supports(update)) return command.handle(update);

        return new SendMessage(update.message().chat().id(), INVALID_COMMAND);
    }
}
