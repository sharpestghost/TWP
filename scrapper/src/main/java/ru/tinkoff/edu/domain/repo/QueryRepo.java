package ru.tinkoff.edu.domain.repo;

import ru.tinkoff.edu.exception.InvalidInputDataException;

import java.util.List;

public interface QueryRepo<T> {
    void add(T o) throws InvalidInputDataException;
    List<T> findAll();
}
