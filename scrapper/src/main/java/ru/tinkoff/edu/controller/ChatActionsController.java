package ru.tinkoff.edu.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/tg-chat/{id}")
public class ChatActionsController {

    public void createChat(@PathVariable long id) {
        //create chat, error handling if occurs
    }

    public void deleteChat(@PathVariable long id) {
        //delete chat, error handling if occurs
    }
}
