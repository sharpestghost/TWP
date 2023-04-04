package ru.tinkoff.edu.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.client.GitHubClient;
import ru.tinkoff.edu.client.ScrapperClient;
import ru.tinkoff.edu.client.StackOverflowClient;

import java.time.Duration;

@Configuration
public class ClientConfiguration {

    @Value("${app.scheduler.interval}")
    private Duration interval;

    @Bean
    public GitHubClient gitHubClient() {
        return new GitHubClient();
    }

    @Bean
    public StackOverflowClient stackOverflowClient() {
        return new StackOverflowClient();
    }

    @Bean
    public ScrapperClient scrapperClient() {
        return new ScrapperClient();
    }

    @Bean
    public String delay(Duration interval) {
        return interval.toString();
    }
}