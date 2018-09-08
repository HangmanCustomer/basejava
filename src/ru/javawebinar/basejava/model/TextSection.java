package ru.javawebinar.basejava.model;

public enum TextSection {

    PERSONAL("-Личные качества"),
    OBJECTIVE("-Позиция");

    private String title;

    TextSection(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
