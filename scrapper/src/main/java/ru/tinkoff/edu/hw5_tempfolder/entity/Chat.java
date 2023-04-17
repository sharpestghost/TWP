package ru.tinkoff.edu.hw5_tempfolder.entity;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
public class Chat {
    @Id
    private Long id;
    private String chatName;
    private String description;
    private OffsetDateTime createdDate;
    private LocalDate lastUpdateDate;
}