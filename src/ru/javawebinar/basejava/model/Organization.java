package ru.javawebinar.basejava.model;

import java.util.Objects;

public class Organization {
    private Link homePage;

    private String startDate;
    private String endDate;
    private String title;
    private String about;

    public Organization(String name, String url, String startDate, String endDate,String title, String about) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(title, "title must not be null");
        this.homePage = new Link(name, url);
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.about = about;
    }

    @Override
    public String toString() {
        return "\n" + homePage + "\n" + startDate + "-" + endDate + "\t" + title + "\n" + about;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(homePage, that.homePage) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, startDate, endDate, title);
    }
}
