package ru.tinkoff.edu.hw5_tempfolder.service;

import ru.tinkoff.edu.ParsedObject;
import ru.tinkoff.edu.hw5_tempfolder.entity.Link;

public interface LinkUpdater {
   void update(ParsedObject object, Link link);
}
