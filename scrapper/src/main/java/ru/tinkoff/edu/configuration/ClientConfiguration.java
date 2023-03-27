package ru.tinkoff.edu.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import reactor.core.Disposable;
import reactor.core.scheduler.Scheduler;
import ru.tinkoff.edu.GitHubClient;
import ru.tinkoff.edu.StackOverflowClient;

import java.time.Duration;

@Configuration
@EnableScheduling
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
    public String delay(Duration interval) {
        return interval.toString();
    }
}