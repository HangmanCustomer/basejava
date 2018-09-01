package ru.javawebinar.basejava.model;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.UUID;

public class Resume implements Comparable<Resume> {

    private final String uuid;

    private String fullName;

    static private Map<String, SectionType> sectionTypes = new TreeMap<>();
    static private Map<Contacts, String> contacts = new TreeMap<>();
    static private Map<String, TextSection> textSections = new TreeMap<>();

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


    public static void main(String[] args) {
        Resume resume = new Resume("Egor");
        System.out.println(resume.getFullName() + "\n");


        for (Contacts cont : Contacts.values()) {
            contacts.put(cont, cont.getValue());
        }
        contacts.forEach((key, value) -> System.out.println(value + " " + key.getContactInfo()));

        System.out.println("\n" + "------||------" + "\n");


        for (TextSection text : TextSection.values()) {
            textSections.put(text.getTitle(), text);
        }
        textSections.forEach((key, value) -> System.out.println(key + "\n" + value.getTextInfo() + "\n"));


        for (SectionType type : SectionType.values()) {
            sectionTypes.put(type.getTitle(), type);
        }
        sectionTypes.forEach((key, value) -> {
            System.out.println(key);
            value.getSectionInfo().forEach(System.out::println);
            System.out.println();
        });
    }
}