package ru.mikhaylin.spring;

import java.util.ArrayList;
import java.util.Date;

public class Message {
    private final String from;
    private final String to;
    private final String date;
    private final String message;

    public Message(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.date = new Date().toString();
        this.message = message;
    }

    @Deprecated
    public void addMessage(String from, String to, String message) {
        new Message(from, to, message);
    }

    public ArrayList<String> getMessage() {
        ArrayList <String> messageAsList = new ArrayList<>();
        messageAsList.add(from);
        messageAsList.add(to);
        messageAsList.add(date);
        messageAsList.add(message);
        return messageAsList;
    }

    public void printMessage() {
        System.out.println(getMessageString());
    }

    public boolean checkSenderAndReceiver(String from, String to) {
        return (this.from.equals(from) || this.from.equals(to)) && (this.to.equals(from) || this.to.equals(to));
    }

    public String getMessageString() {
        return "From: " + from + " To: " + from + " Datetime: " + date + " Message: " + message;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    public String getMess() {
        return message;
    }

}
