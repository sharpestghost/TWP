package ru.tinkoff.edu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "url")
    private String URL;

    @Column(name = "linkname")
    private String linkName;

    @Column(name = "updated_at")
    private OffsetDateTime lastUpdateDate;

    @Column(name = "answer_count")
    private Integer answerCount;
}
