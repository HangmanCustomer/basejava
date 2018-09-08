package ru.javawebinar.basejava.model;

public enum ContactType {
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

    public String getRuValue() {
        return ruValue;
    }

    public abstract String getContactInfo();

}
