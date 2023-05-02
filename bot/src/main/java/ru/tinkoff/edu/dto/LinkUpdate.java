package ru.tinkoff.edu.dto;

public record LinkUpdate(long id, String url, String description, long[] tgChatIds) {
}
