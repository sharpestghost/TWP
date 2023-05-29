package ru.tinkoff.edu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.scrapperlink.dto.request.LinkUpdate;
import ru.tinkoff.edu.service.recipient.UpdateRecipient;

@RestController
@RequiredArgsConstructor
public class UpdatesController {
    private UpdateRecipient updateRecipient;

    @PostMapping("/updates")
    public void update(@RequestBody LinkUpdate linkUpdate) {
        updateRecipient.recieveUpdate(linkUpdate);
    }
}
