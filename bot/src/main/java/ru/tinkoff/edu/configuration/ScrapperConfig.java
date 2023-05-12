package ru.tinkoff.edu.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration("scrapper")
@ConfigurationProperties(prefix = "client.scrapper")
public class ScrapperConfig {
    @Value("${baseUrl:http://localhost:8080}")
    private static String baseUrl;

    public static String getBaseUrl() {
        return baseUrl;
    }
}