package ru.mikhaylin.spring;

import java.util.*;
import java.util.stream.Collectors;

public class MembersList {
    private static MembersList membersList;

    private MembersList() {

    }

    public static MembersList getMemberList() {
        if (membersList == null) {
            membersList = new MembersList();
        }
        return membersList;
    }

    public ArrayList<String> getList() {
        Registered registered = Registered.getDataBaseRegistered();
        Set<String> registeredSet = registered.getMap().keySet();
        return new ArrayList<String>(registeredSet);
    }

    public void viewMembers() {
        for (String member: membersList.getList()) {
            System.out.println(member);
        }
    }


}