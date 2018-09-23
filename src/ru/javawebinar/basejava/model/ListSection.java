package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.Objects;

public class ListSection implements Sections {
    private ArrayList<String> info;

    public ListSection(ArrayList<String> info) {
        Objects.requireNonNull(info, "Section must not be null");
        this.info = info;
    }

    @Override
    public String toString() {
        return info.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info);
    }
}
