package ru.tinkoff.edu.configuration;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.validation.annotation.Validated;
import reactor.core.scheduler.Scheduler;

@Configuration
@EnableScheduling
@Validated
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public record ApplicationConfig(@NotNull String test,  @NotNull Scheduler scheduler) {}