package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.Objects;

public class OrganizationSection implements Sections {
    private ArrayList<Organization> info;

    public OrganizationSection(ArrayList<Organization> info) {
        Objects.requireNonNull(info, "Organization must not be null");
        this.info = info;
    }

    public void sameOrganization(){ //использовать хэшкод для разных периодов в организации
        info.forEach(x -> System.out.println(x.homePage.hashCode()));
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
