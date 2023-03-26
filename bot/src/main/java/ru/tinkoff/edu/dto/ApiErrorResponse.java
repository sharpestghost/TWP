package ru.tinkoff.edu.dto;

public record ApiErrorResponse(String description, String code, String exceptionName, String exceptionMessage,
                               String[] stackTrace) {
}
