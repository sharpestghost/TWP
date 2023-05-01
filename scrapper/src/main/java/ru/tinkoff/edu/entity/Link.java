package ru.tinkoff.edu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "link")
public class Link {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "url", unique = true, nullable = false)
    private String URL;

    @Column(name = "linkname")
    private String linkName;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime lastUpdateDate;

    @Column(name = "answer_count")
    private Integer answerCount;
}
