package com.example.informationpublishersimulator;

public class User {
    String name;
    String id;
    String className;
    Double mark;

    User(String id, String name, String className, Double mark) {
        this.id = id;
        this.className = className;
        this.mark = mark;
        this.name = name;
    }
}
