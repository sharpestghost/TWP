package ru.tinkoff.edu.hw5_tempfolder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkChat {
    private Long chatId;
    private Long linkId;
}