package ru.tinkoff.edu.hw5_tempfolder.service;

import ru.tinkoff.edu.hw5_tempfolder.entity.LinkChat;

import java.util.List;

public interface LinkChatUpdater {
    void add(LinkChat linkChat);
    void remove(LinkChat linkChat);
    List<LinkChat> findAll();
    List<LinkChat> getLinksByChatId(long chatId);
    List<LinkChat> getChatsByLink(long linkId);
}
