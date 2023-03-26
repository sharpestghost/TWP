package ru.tinkoff.edu;

import java.net.URL;

public abstract class Parser {
    Parser nextParser;

    Parser (Parser nextParser) {
        this.nextParser = nextParser;
    }

    abstract ParsedObject parseLink(URL url);

    public ParsedObject parse(URL url) {
        ParsedObject res = parseLink(url);
        if (res != null) {
            return res;
        }
        if (nextParser != null) {
            return nextParser.parse(url);
        }
        return null;
    }
}