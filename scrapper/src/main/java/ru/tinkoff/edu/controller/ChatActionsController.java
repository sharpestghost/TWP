package ru.tinkoff.edu.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.service.ChatService;

@AllArgsConstructor
@RestController
@RequestMapping("/tg-chat")
public class ChatActionsController {
    private final ChatService service;
    private static final String TG_CHAT_ID_HEADER = "Tg-Chat-Id";

    @PostMapping(value = "/{id}")
    public void registerChat(@PathVariable("id") Long id, @RequestHeader(name = TG_CHAT_ID_HEADER) String username) {
        service.register(id, username);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteChat(@PathVariable("id") Long id) {
        service.unregister(id);
    }
}
