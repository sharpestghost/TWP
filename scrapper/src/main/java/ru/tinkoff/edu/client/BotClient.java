package ru.tinkoff.edu.client;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.tinkoff.edu.dto.request.LinkUpdate;

import java.time.Duration;

public class BotClient {
    private static final String BASE_URL = "https://localhost:8080";
    private final WebClient webClient;

    public BotClient() {
        webClient = WebClient.builder().baseUrl(BASE_URL).build();
    }

    public BotClient(String url) {
        webClient = WebClient.builder().baseUrl(url).build();
    }

    public void update(LinkUpdate request) {
        webClient.post().uri("updates").body(Mono.just(request), LinkUpdate.class)
                .retrieve().bodyToMono(Mono.class).timeout(Duration.ofMillis(15000))
                .block();
    }

}
