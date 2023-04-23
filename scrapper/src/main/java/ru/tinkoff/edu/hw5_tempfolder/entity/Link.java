package ru.tinkoff.edu.hw5_tempfolder.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    @Id
    private Long id;
    private String URL;
    private String linkName;
    private String description;
    private OffsetDateTime lastUpdateDate;

}
