package ru.tinkoff.edu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkChat {
    private Long chatId;
    private Long linkId;
}