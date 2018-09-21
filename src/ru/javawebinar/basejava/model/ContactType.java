package ru.javawebinar.basejava.model;

public enum ContactType {
    PHONE("Тел.:"),
    SKYPE("Skype:"),
    MAIL("Почта:"),
    LINKED_IN("профиль LinkedIn:"),
    GITHUB("Профиль GitHub:"),
    STACK_OVER_FLOW("Профиль StackOverFlow:"),
    HOME_PAGE("Домашняя страница:");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
