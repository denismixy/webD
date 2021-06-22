package ru.mikhaylin.spring;

import java.util.HashMap;
import java.util.Map;

public class Registered {
    private static Registered dataBaseRegistered;
    private HashMap<String, String> registeredMap = new HashMap<>();

    private Registered() {

    }

    public static Registered getDataBaseRegistered() {
        if (dataBaseRegistered == null) {
            dataBaseRegistered = new Registered();
        }
        return dataBaseRegistered;
    }

    public boolean addNewUser(String login, String password) {
        if (registeredMap.containsKey(login)) {
            System.out.println("Пользователь с таким логином уже зарегестрирован");
            return false;
        }
        registeredMap.put(login, password);
        return true;
    }

    public void deleteUser(String login) {
        if (registeredMap.containsKey(login)) {
            registeredMap.remove(login);
            System.out.println("Пользователь удален");
        }
        else {
            System.out.println("Удаление невозможно, пользователь не существует");
        }
    }

    public Map<String, String> getMap() {
        return registeredMap;
    }

}
