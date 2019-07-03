package com.example.g10_excercise.studentexamlist;

public class examData {
    final String name;
    final String date;
    final String message;
    final int id1;

    public examData(int id1, String name, String date, String message) {
        this.name = name;
        this.date = date;
        this.message = message;
        this.id1 = id1;
    }

    public int getId() {
        return id1;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
    public String getMessage() {
        return message;
    }
}
