package ru.javawebinar.basejava.model;

public enum ContactType {
    //hope it will be on a github
    PHONE("Тел.:"),
    SKYPE("Skype:"),
    MAIL("Почта:"),
    LINKED_IN("профиль LinkedIn:"),
    GITHUB("Профиль GitHub:"),
    STACK_OVER_FLOW("Профиль StackOverFlow:"),
    HOME_PAGE("Домашняя страница:");

    private String ruValue;

    Contacts(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ruValue;
    }
}
