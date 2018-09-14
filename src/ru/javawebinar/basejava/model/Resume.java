package ru.javawebinar.basejava.model;

import java.util.*;

public class Resume implements Comparable<Resume> {

    private final String uuid;

    private String fullName;

    static private Map<String, SectionType> sectionTypes = new HashMap<>();

    static private Map<Contacts, String> contacts = new EnumMap<>(Contacts.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "fullName must not be null");
        Objects.requireNonNull(fullName, "uuid must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) &&
                Objects.equals(fullName, resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }

    @Override
    public String toString() {
        return uuid + " " + fullName;
    }

    @Override
    public int compareTo(Resume resume) {
        int result = fullName.compareTo(resume.fullName);
        return result != 0 ? result : uuid.compareTo(resume.uuid);
    }

    public void setContact(ContactType type, String contactInfo) {
        getContacts().put(type, contactInfo);
    }

    public void setSection(SectionType type, Object sectionInfo){
        getSectionType().put(type, sectionInfo);
    }

    public static void main(String[] args) {
        Resume resume = new Resume("re");
        resume.setSection(SectionType.ACHIEVEMENT, new ArrayList<String>(Arrays.asList("first achiv", "sec achiv")));
        resume.setSection(SectionType.OBJECTIVE, "position");
        resume.setSection(SectionType.PERSONAL, "about me");
        resume.setSection(SectionType.QUALIFICATIONS, new ArrayList<String>(Arrays.asList("first qua", " sec qua")));

        resume.getSectionType().forEach((k, v) -> System.out.println(k + " "+  v));

    }
}