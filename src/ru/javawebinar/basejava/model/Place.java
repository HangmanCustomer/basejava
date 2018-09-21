package ru.javawebinar.basejava.model;

import java.util.Objects;

public class Place {
    private String name;
    private String startDate;
    private String endDate;
    private String about;

    public Place(String name, String startDate,String endDate, String about) {
        Objects.requireNonNull(name, "Section must not be null");
        Objects.requireNonNull(startDate, "Section must not be null");
        Objects.requireNonNull(endDate, "Section must not be null");
        Objects.requireNonNull(about, "Section must not be null");
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.about = about;
    }

    @Override
    public String toString() {
        return "\n" + name + "\n" + startDate + "-" + endDate + "\t" + about;
    }
}
