package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.Objects;

public class PlaceSection extends Sections {
    private ArrayList<Place> info;

    public PlaceSection(ArrayList<Place> info) {
        Objects.requireNonNull(info, "Section must not be null");
        this.info = info;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
