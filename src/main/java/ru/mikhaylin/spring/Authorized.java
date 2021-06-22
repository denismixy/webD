package ru.mikhaylin.spring;

import java.util.HashMap;

public class Authorized {
    private static Authorized dataBaseAuthorized;
    private HashMap<String, Integer> authorized = new HashMap<>();
    private HashMap<String, String> authorizedMirror = new HashMap<>();
    private Registered registered = Registered.getDataBaseRegistered();

    private Authorized() {

    }

    public static Authorized getDataBaseAuthorized() {
        if (dataBaseAuthorized == null) {
            dataBaseAuthorized = new Authorized();
        }
        return dataBaseAuthorized;
    }

    public boolean addAuthorizedUser(String login, String password) {
        if (registered.getMap().get(login) == null || !registered.getMap().get(login).equals(password)) {
            System.out.println("пароль не верен");
            return false;
        } else {
            authorized.put(login, login.hashCode());
            authorizedMirror.put(String.valueOf(login.hashCode()), login);
            System.out.println(login.hashCode());
            return true;
        }
    }

    public void authorizedOut(String hash) {
        if (authorizedMirror.containsKey(hash)) {
            String login = authorizedMirror.get(hash);
            authorized.remove(login);
            System.out.println("Выполнен выход");
        } else {
            System.out.println("Вы не авторизованы");
        }
    }

    public void checkAuthorizedByHash(String hash) {
        if (authorizedMirror.containsKey(hash)) {
            System.out.println("Пользователь авторизован");
        } else {
            System.out.println("Пользователь не авторизован");
        }
    }

    public void checkAuthorizedByLogin(String login) {
        if (authorized.containsKey(login)) {
            System.out.println("Пользователь авторизован");
        } else {
            System.out.println("Пользователь не авторизован");
        }
    }

    public HashMap<String, Integer> getMap() {
        return authorized;
    }
}