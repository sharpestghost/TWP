package ru.tinkoff.edu.exception;

public class InvalidInputDataException extends Exception {
    public InvalidInputDataException() {
        super("Query data were entered incorrectly.");
    }
}
