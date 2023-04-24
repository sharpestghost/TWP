package ru.tinkoff.edu.client;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.GithubRepo;
import ru.tinkoff.edu.dto.response.RepoResponse;

import java.time.OffsetDateTime;

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

    public RepoResponse getRepo(GithubRepo githubRepo) {
        try {
            JSONObject obj = new JSONObject(requestRepo(githubRepo.user(), githubRepo.repo()));
            return new RepoResponse(obj.getString("full_name"),
                    OffsetDateTime.parse(obj.getString("pushed_at")));
        } catch (JSONException e) {
            return null;
        }
    }

}