package com.example.mukt;

public class UserMessage {
    String content;

    public UserMessage(String content) {
        this.content = content;
    }

    public String getUserMessage() {
        return content;
    }

    public void setUserMessage(String content) {
        this.content = content;
    }
}
