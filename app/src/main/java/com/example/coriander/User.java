package com.example.coriander;

public class User {

    private String name;
    private String number;
    private String id;

    public User(String nname, String nnumber,String nid){
        name = nname;
        number = nnumber;
        id = nid;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getID() {
        return id;
    }
}
