package com.example.liuhe.eventbusdemo;

/**
 * Created by liuhe on 2017/9/16.
 */

public class MessageEvent {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
