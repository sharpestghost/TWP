package ru.tinkoff.edu.client;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.dto.response.QuestionResponse;
import java.time.Duration;

public class StackOverflowClient {
    private static final String STACKOVERFLOW_URL = "https://api.stackexchange.com";
    private final WebClient webClient;

    public StackOverflowClient() {
        webClient = returnBaseClient();
    }

    public StackOverflowClient(String url) {
        webClient = returnClientByLink(url);
    }

    @Bean
    public WebClient returnBaseClient() {
        return WebClient.builder().baseUrl(STACKOVERFLOW_URL).build();
    }

    @Bean
    public WebClient returnClientByLink(String url) {
        return WebClient.builder().baseUrl(url).build();
    }

    public QuestionResponse getQuestion(long id) {
        return webClient.get()
                .uri("/questions/" + id + "?site=stackoverflow")
                .retrieve().bodyToMono(QuestionResponse.class)
                .timeout(Duration.ofSeconds(15)).block();
    }
}
