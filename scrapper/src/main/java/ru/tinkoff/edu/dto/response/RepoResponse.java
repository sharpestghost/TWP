package ru.tinkoff.edu.dto.response;

import java.time.OffsetDateTime;

public record RepoResponse(String name, OffsetDateTime lastUpdateDate) {
}
