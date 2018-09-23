package ru.javawebinar.basejava.model;

import java.util.Objects;

public class TextSection implements Sections {
    private String info;

    public TextSection(String info) {
        Objects.requireNonNull(info, "info must not be null");
        this.info = info;
    }

    @Override
    public String toString() {
        return "\n" + info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
        return Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info);
    }
}
