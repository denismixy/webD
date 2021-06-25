package ru.mikhaylin.spring;

import java.util.ArrayList;

public class Chat {
    private ArrayList<Message> chat = new ArrayList<>();

    public Chat() {

    }

    public void addMessage(String from, String to, String message) {
        Message newMessage = new Message(from, to, message);
        chat.add(newMessage);
    }

    public void deleteMessage(int numberMessage) {
        chat.remove(numberMessage);
    }

    public void editMessage(String from, String to, int numberMessage, String editVersion) {
        Message newMessage = chat.get(numberMessage);
        newMessage.getMessage().remove(3);
        newMessage.getMessage().add(editVersion);
    }

    public ArrayList<Message> getChat() {
        return chat;
    }

    public boolean checkSenderAndReciver(String from, String to) {
        return chat.get(0).checkSenderAndReceiver(from, to);
    }
}