package ru.tinkoff.edu.scrapperlink.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.tinkoff.edu.scrapperlink.dto.request.AddLinkRequest;
import ru.tinkoff.edu.scrapperlink.dto.request.RemoveLinkRequest;
import ru.tinkoff.edu.scrapperlink.dto.response.LinkResponse;
import ru.tinkoff.edu.scrapperlink.dto.response.ListLinksResponse;

public class ScrapperClient {
    public final WebClient webClient;
    private static final String BASE_URL = "http://localhost:8080";
    private static final String TG_CHAT_ID_LINK = "/tg-chat/";
    private static final String TG_CHAT_ID_HEADER = "Tg-Chat-Id";
    private static final String LINKS = "/links";
    private static final long TIMEOUT = 30L;

    public ScrapperClient(String url) {
        webClient = WebClient.builder().baseUrl(url).build();
    }

    public ScrapperClient() {
        webClient = WebClient.builder().baseUrl(BASE_URL).build();
    }

    public void addChat(long id, @NotNull String name) {
        webClient.post().uri(TG_CHAT_ID_LINK + String.valueOf(id))
            .header(TG_CHAT_ID_HEADER, name)
            .retrieve()
            .bodyToMono(Void.class)
            .timeout(Duration.ofSeconds(TIMEOUT))
            .block();
    }

    public ListLinksResponse getLinks(long tgChatId) {
        return webClient.get()
            .uri(LINKS)
            .header(TG_CHAT_ID_HEADER, String.valueOf(tgChatId))
            .retrieve()
            .bodyToMono(ListLinksResponse.class)
            .timeout(Duration.ofSeconds(TIMEOUT))
            .onErrorReturn(new ListLinksResponse(new LinkResponse[0], 0))
            .block();
    }

    public boolean addLink(long tgChatId, String link) {
        AddLinkRequest request;
        try {
            request = new AddLinkRequest(new URI(link));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        LinkResponse response = webClient.post()
            .uri(LINKS)
            .header(TG_CHAT_ID_HEADER, String.valueOf(tgChatId))
            .body(Mono.just(request), AddLinkRequest.class)
            .retrieve()
            .bodyToMono(LinkResponse.class)
            .timeout(Duration.ofSeconds(TIMEOUT))
            .block();
        return response != null && response.url() != null;
    }

    public LinkResponse deleteLink(long id, RemoveLinkRequest request) {
        return webClient.method(HttpMethod.DELETE)
                .uri(LINKS, id)
                .header(TG_CHAT_ID_HEADER, String.valueOf(id))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(LinkResponse.class)
                .block();
    }

    public void deleteChat(long id) {
        webClient.delete()
            .uri(TG_CHAT_ID_LINK, id).retrieve().toBodilessEntity().block();
    }

}
