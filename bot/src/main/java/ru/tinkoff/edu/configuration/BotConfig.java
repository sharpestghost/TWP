package ru.tinkoff.edu.configuration;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.bot.commands.BotCommandsList;
import ru.tinkoff.edu.bot.commands.CommandInfo;
import ru.tinkoff.edu.bot.commands.InputCommandsHandler;
import ru.tinkoff.edu.bot.logic.Bot;
import ru.tinkoff.edu.scrapperlink.client.ScrapperClient;

@Configuration
@RequiredArgsConstructor
public class BotConfig {
    private final ApplicationConfig config;
    private final InputCommandsHandler handler;
    private final ScrapperClient client;

    @Bean("bot")
    public Bot launch() {
        List<CommandInfo> supported = new ArrayList<>();
        for (BotCommandsList command : BotCommandsList.values()) {
            supported.add(command.getCommand());
        }
        Bot bot = new Bot(config.accessToken(), supported, handler);
        bot.start();
        return bot;
    }
}




