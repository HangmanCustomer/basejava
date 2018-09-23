package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.Objects;

public class OrganizationSection implements Sections {
    private ArrayList<Organization> info;

    public OrganizationSection(ArrayList<Organization> info) {
        Objects.requireNonNull(info, "Organization must not be null");
        this.info = info;
    }



    @Override
    public String toString() {
        return info.toString();
    }
}
