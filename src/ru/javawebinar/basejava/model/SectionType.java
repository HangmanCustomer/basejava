package ru.javawebinar.basejava.model;

public enum SectionType {
    //hope it will be on a github
    PERSONAL("-Личные качества"),
    OBJECTIVE("-Позиция"),
    ACHIEVEMENT("-Достижения"),
    QUALIFICATIONS("-Квалификация"),
    EXPERIENCE("-Опыт работы"),
    EDUCATION("-Образование");

    private String title;

    SectionType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

}
