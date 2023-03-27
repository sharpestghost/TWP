package ru.tinkoff.edu;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class GitHubClient {

    private static final String GITHUB_URL = "https://api.github.com";
    private final WebClient webClient;

    public GitHubClient() {
        webClient = returnBaseClient();
    }

    public GitHubClient(String url) {
        webClient = returnClientByLink(url);
    }

    @Bean
    public WebClient returnBaseClient() {
        return WebClient.builder().baseUrl(GITHUB_URL).build();
    }

    @Bean
    public WebClient returnClientByLink(String url) {
        return WebClient.builder().baseUrl(url).build();
    }

    private String requestRepo(String user, String repo) {
        return webClient.get().uri("/repos/" + user + "/" + repo).retrieve().
                bodyToMono(String.class).share().toString();
    }

}