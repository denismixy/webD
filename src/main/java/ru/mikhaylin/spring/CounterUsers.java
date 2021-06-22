package ru.mikhaylin.spring;

public class CounterUsers {
    private static CounterUsers counterUsers;
    private int numberInAuthorizedBase = 0;

    private CounterUsers() {

    }

    public static CounterUsers getCounterUsers() {
        if (counterUsers == null) {
            counterUsers = new CounterUsers();
        }
        return counterUsers;
    }

    public void addUser() {
        numberInAuthorizedBase++;
    }

    public int getNumberInAuthorizedBase() {
        return numberInAuthorizedBase;
    }
}
