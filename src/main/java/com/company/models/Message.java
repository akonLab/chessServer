package com.company.models;

import javax.servlet.http.Part;

public class Message {
    private final String from;
    private final String message;
    private final Part file;
    private final String date;

    public Message(String from, String message, Part file, String date) {
        this.message = message;
        this.from = from;
        this.file = file;
        this.date = date;
    }

    public Part getFile() {
        return file;
    }

    public String getMessage() {
        return message;
    }

    public String getFrom() {
        return from;
    }

    public String getDate() {
        return date;
    }
}
