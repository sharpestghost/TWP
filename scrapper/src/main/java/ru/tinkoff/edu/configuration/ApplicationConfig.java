package ru.tinkoff.edu.configuration;

import jakarta.validation.constraints.NotNull;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public record ApplicationConfig(@NotNull String test,
                                @NotNull Scheduler scheduler,
                                @NotNull AccessType dbAccessType,
                                @NotNull String queueName,
                                @NotNull String exchangeName,
                                @NotNull boolean useQueue) {

public record Scheduler(@Value("${app.scheduler.interval}") Duration interval) {

}

enum AccessType {
    JDBC,
    JPA,
    JOOQ
}
}
