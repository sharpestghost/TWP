package ru.tinkoff.edu.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.converter.ResponseConverter;
import ru.tinkoff.edu.dto.request.AddLinkRequest;
import ru.tinkoff.edu.dto.request.RemoveLinkRequest;
import ru.tinkoff.edu.dto.response.LinkResponse;
import ru.tinkoff.edu.dto.response.ListLinksResponse;
import ru.tinkoff.edu.service.LinkChatService;
import ru.tinkoff.edu.service.LinkService;

@AllArgsConstructor
@RestController
@RequestMapping("/links")
public class LinksController {

    private final LinkService linkService;
    private final LinkChatService linkChatService;
    private static final String TG_CHAT_ID_HEADER = "Tg-Chat-Id";

    @GetMapping
    public ListLinksResponse getLinks(@RequestHeader(name = TG_CHAT_ID_HEADER) long id) {
        return ResponseConverter.getListLinksResponse(linkService.listAll(id));
    }

    @PostMapping
    public LinkResponse addLink(@RequestHeader(name = TG_CHAT_ID_HEADER) long id, @RequestBody AddLinkRequest request) {
        return ResponseConverter.getLinkResponse(linkService.add(id, request.link()));
    }

    @DeleteMapping
    public LinkResponse removeLink(@RequestHeader(name = TG_CHAT_ID_HEADER) long id, @RequestBody RemoveLinkRequest request) {
        return ResponseConverter.getLinkResponse(linkChatService.untrack(id, request.link().toString()));
    }
}
