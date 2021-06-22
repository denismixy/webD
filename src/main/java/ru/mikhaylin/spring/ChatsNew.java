package ru.mikhaylin.spring;

import java.util.*;

public class ChatsNew {
    private static ChatsNew DataBaseChats;
    private ArrayList<Chat> chatsList = new ArrayList<>();
    private HashMap<String, HashSet<String>> existDialog = new HashMap<>();
    private MembersList membersList = MembersList.getMemberList();

    private ChatsNew() {

    }

    public static ChatsNew getDataBaseChats() {
        if (DataBaseChats == null) {
            DataBaseChats = new ChatsNew();
        }
        return DataBaseChats;
    }

    public boolean checkExistDialog(String from, String to) {
        if (existDialog.get(from) != null) {
            if (existDialog.get(from).contains(to)) {
                return true;
            }
        }
        if (existDialog.get(to) != null) {
            if (existDialog.get(to).contains(from)) {
                return true;
            }
        }
        return false;
    }

    public void addChat(String from, String to, String message) {
        if (membersList.getList().contains(to)) {
            Chat chat = new Chat();
            chat.addMessage(from, to, message);
            chatsList.add(chat);
            if (existDialog.get(from) == null) {
                HashSet<String> addSet = new HashSet<>();
                addSet.add(to);
                existDialog.put(from, addSet);
            } else  {
                HashSet<String> addSet = existDialog.get(from);
                addSet.add(to);
                existDialog.put(from, addSet);
            }
        } else {
            System.out.println("Пользователь не существует, отправка сообщения невозможна");
        }
    }

    public void addMessage(String from, String to, String message) {
        if (checkExistDialog(from, to)) {
            for (Chat chat: chatsList) {
                if (chat.checkSenderAndReciver(from, to)) {
                    chat.addMessage(from, to, message);
                }
            }
        } else {
            addChat(from, to, message);
        }
    }

    public void deleteMessage(String from, String to, int numberMessage) {
        for (Chat chat: chatsList) {
            if (chat.checkSenderAndReciver(from, to)) {
                chat.deleteMessage(numberMessage);
            }
        }
    }

    public void editMessage(String from, String to, int numberMessage, String editVersion) {
        for (Chat chat: chatsList) {
            if (chat.checkSenderAndReciver(from, to)) {
                chat.editMessage(from, to, numberMessage, editVersion);
            }
        }
    }

    public void printChat(String from, String to) {
        for (Chat chat: chatsList) {
            if (chat.checkSenderAndReciver(from, to)) {
                for (Message message: chat.getChat()) {
                    message.printMessage();
                }
            }
        }
    }

    public void printMessage(String from, String to, int numberMessage) {
        for (Chat chat: chatsList) {
            if (chat.checkSenderAndReciver(from, to)) {
                int counter = 0;
                for (Message message: chat.getChat()) {
                    if (counter == numberMessage) {
                        message.printMessage();
                        return;
                    } else {
                        counter++;
                    }
                }
            }
        }
    }

    public List getChatList(String from, String to) {
        ArrayList<String> outList = new ArrayList<>();
        for (Chat chat: chatsList) {
            if (chat.checkSenderAndReciver(from, to)) {
                for (Message message: chat.getChat()) {
                    outList.add(message.getMessageString());
                }
                return outList;
            }
        }
        outList.add("Получатель не существует");
        return outList;
    }
}
