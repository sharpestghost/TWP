package ru.tinkoff.edu;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.tinkoff.edu.bot.Bot;
import ru.tinkoff.edu.bot.commands.*;
import ru.tinkoff.edu.configuration.ApplicationConfig;
import ru.tinkoff.edu.scrapperlink.client.ScrapperClient;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableConfigurationProperties(ApplicationConfig.class)
public class BotApplication {
public static void main(String []args) throws InterruptedException {
        var ctx= SpringApplication.run(BotApplication.class,args);
        ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
        InputCommandsHandler handler = ctx.getBean(InputCommandsHandler.class);
        ScrapperClient client = ctx.getBean(ScrapperClient.class);
        List<CommandInfo> supported = new ArrayList<>();
        supported.add(new ListCommand());
        supported.add(new HelpCommand(client));
        supported.add(new StartCommand());
        supported.add(new TrackCommand());
        supported.add(new UntrackCommand());
        System.out.println(config.accessToken());

        Bot bot = new Bot(config.accessToken(), supported, handler);
        bot.start();
        System.out.println("bot started");
        }

        @Bean
        public ScrapperClient scrapperClient() {
                return new ScrapperClient();
        }
}