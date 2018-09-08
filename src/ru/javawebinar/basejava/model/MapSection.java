package ru.javawebinar.basejava.model;

public enum MapSection {
    EXPERIENCE("-Опыт работы"),
    EDUCATION("-Образование");

    private String title;

    MapSection(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
