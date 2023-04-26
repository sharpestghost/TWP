package ru.tinkoff.edu.domain.jdbc.repo;

import ru.tinkoff.edu.exception.InvalidInputDataException;
import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;

import java.util.List;

public interface QueryRepo<T> {
    void add(T o) throws InvalidInputDataException;
    List<T> findAll();
}
