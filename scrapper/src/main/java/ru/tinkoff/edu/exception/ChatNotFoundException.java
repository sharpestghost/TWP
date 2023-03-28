package ru.tinkoff.edu.exception;

public class ChatNotFoundException extends RuntimeException {
    ChatNotFoundException(String msg) {
        super(msg);
    }
}
