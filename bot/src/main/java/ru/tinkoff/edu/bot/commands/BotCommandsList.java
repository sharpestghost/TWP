package ru.tinkoff.edu.bot.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import ru.tinkoff.edu.scrapperlink.client.ScrapperClient;

@Getter
public enum BotCommandsList {

    START("/start", "registers a new user", new StartCommand(new ScrapperClient())),
    LIST("/list", "prints a list of current commands", new ListCommand(new ScrapperClient())),
    HELP("/help", "displays a list of tracking links", new HelpCommand(new ScrapperClient())),
    TRACK("/track", "starts tracking a link", new TrackCommand(new ScrapperClient())),
    UNTRACK("/untrack", "stops tracking a link", new UntrackCommand(new ScrapperClient()));

    private static final Map<String, CommandInfo> COMMANDS = new HashMap<>();
    private final String name;
    private final String description;
    private final CommandInfo command;

    static {
        Arrays.stream(values()).forEach(v -> COMMANDS.put(v.name, v.command));
    }

    static Map<String, CommandInfo> getCommands() {
        return COMMANDS;
    }

    BotCommandsList(String name, String description, CommandInfo command) {
        this.name = name;
        this.command = command;
        this.description = description;
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }
}
