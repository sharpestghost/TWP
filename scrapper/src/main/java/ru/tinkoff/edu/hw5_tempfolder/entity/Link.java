package ru.tinkoff.edu.hw5_tempfolder.entity;

import nonapi.io.github.classgraph.json.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
public class Link {
    @Id
    private Long id;
    private String URL;
    private String linkName;
    private OffsetDateTime createdDate;
    private LocalDate lastUpdateDate;
}
