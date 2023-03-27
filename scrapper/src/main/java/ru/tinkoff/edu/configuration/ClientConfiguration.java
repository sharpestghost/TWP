package ru.tinkoff.edu.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.GitHubClient;
import ru.tinkoff.edu.StackOverflowClient;

@Configuration
public class ClientConfiguration {

    @Bean
    public GitHubClient gitHubClient() {
        return new GitHubClient();
    }

    @Bean
    public StackOverflowClient stackOverflowClient() {
        return new StackOverflowClient();
    }
}