package ru.javawebinar.basejava.model;

public class TextSection extends Sections {
    private String info;

    public TextSection(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "\n" + info;
    }
}
