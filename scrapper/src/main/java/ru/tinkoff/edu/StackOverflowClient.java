package ru.tinkoff.edu;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;


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

    private String requestQuestion(long id) {
        return webClient.get().uri("/questions/" + id + "?site=stackoverflow").
                retrieve().bodyToMono(String.class).share().block();
    }
}
