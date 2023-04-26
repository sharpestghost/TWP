package ru.tinkoff.edu.configuration;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import reactor.core.scheduler.Scheduler;

@Validated
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public record ApplicationConfig(@NotNull String test,  @NotNull Scheduler scheduler,@NotNull AccessType dbAccessType) {}

enum AccessType {
    JDBC,
    JPA,
    JOOQ
}