package ru.mikhaylin.spring;

public class Main {
    public static void main(String[] args) {
        Registered registered = Registered.getDataBaseRegistered();
        Authorized authorized = Authorized.getDataBaseAuthorized();
        MembersList membersList = MembersList.getMemberList();
        ChatsNew chatsNew = ChatsNew.getDataBaseChats();
    }
}
