package ru.javawebinar.basejava.model;

import java.util.Objects;

public class TextSection extends Sections {
    private String info;

    public TextSection(String info) {
        Objects.requireNonNull(info, "Section must not be null");
        this.info = info;
    }

    @Override
    public String toString() {
        return "\n" + info;
    }
}
