package ru.tinkoff.edu.exception;

public class DataNotFoundException extends RuntimeException {
    DataNotFoundException(String msg) {
        super(msg);
    }
}
