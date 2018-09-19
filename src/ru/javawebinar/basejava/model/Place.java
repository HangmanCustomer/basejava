package ru.javawebinar.basejava.model;

public class Place {
    private String name;
    private String date;
    private String about;

    public Place(String name, String date, String about) {
        this.name = name;
        this.date = date;
        this.about = about;
    }

    @Override
    public String toString() {
        return "\n" + name + "\n" + date + "\t" + about;
    }
}
