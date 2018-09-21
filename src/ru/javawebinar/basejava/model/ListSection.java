package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.Objects;

public class ListSection extends Sections {
    private ArrayList<String> info;

    public ListSection(ArrayList<String> info) {
        Objects.requireNonNull(info, "Section must not be null");
        this.info = info;
    }

    @Override
    public String toString() {
        return  info.toString();
    }
}
