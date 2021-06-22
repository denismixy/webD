package ru.mikhaylin.spring;

import java.util.ArrayList;
import java.util.Date;

public class Message {
    private ArrayList<String> message = new ArrayList<>();

    public Message() {

    }

    public void addMessage(String from, String to, String message) {
        Date date = new Date();
        this.message.add(from);
        this.message.add(to);
        this.message.add(date.toString());
        this.message.add(message);
    }

    public ArrayList<String> getMessage() {
        return message;
    }

    public void printMessage() {
        String outString = " от кого: " + message.get(0) + " кому: " + message.get(1) + " дата сообщения: " + message.get(2) + " текст сообщения: " + message.get(3);
        System.out.println(outString);
    }

    public boolean checkSenderAndReciver(String from, String to) {
        if ((message.get(0).equals(from) || message.get(0).equals(to)) && (message.get(1).equals(from) || message.get(1).equals(to))) {
            return true;
        } else {
            return false;
        }
    }

    public String getMessageString() {
        String outString = "From: " + message.get(0) + " To: " + message.get(1) + " Datetime: " + message.get(2) + " Message: " + message.get(3);
        return outString;
    }
}
