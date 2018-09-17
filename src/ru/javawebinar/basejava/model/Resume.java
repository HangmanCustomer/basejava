package ru.javawebinar.basejava.model;

import java.util.*;

public class Resume implements Comparable<Resume> {

    private final String uuid;

    private String fullName;

    private Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private Map<SectionType, Object> sectionType = new EnumMap<>(SectionType.class);

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

    public void setSection(SectionType type, Object sectionInfo) {
        getSectionType().put(type, sectionInfo);
    }

    public static void main(String[] args) {
        Resume resume1 = new Resume("First name");

        resume1.setContact(ContactType.PHONE, "777-77-77");
        resume1.setSection(SectionType.OBJECTIVE, "position");
        resume1.setSection(SectionType.PERSONAL, "about me");
        resume1.setSection(SectionType.ACHIEVEMENT, new ArrayList<>(Arrays.asList("first achive", "second achive")));
        resume1.setSection(SectionType.QUALIFICATIONS, new ArrayList<>(Arrays.asList("first qua", " sec qua")));

        HashMap<String, String> edu = new HashMap<>();
        HashMap<String, String> exp = new HashMap<>();
        edu.put("school", "about");
        edu.put("university", "about");
        exp.put("first place", "about work");
        exp.put("second place", "about work");
        resume1.setSection(SectionType.EDUCATION, edu);
        resume1.setSection(SectionType.EXPERIENCE, exp);

        System.out.println(resume1.getFullName());
        resume1.getContacts().forEach((k, v) -> System.out.println(k + " " + v));
        resume1.getSectionType().forEach((k, v) -> System.out.println(k + " " + v));

        Resume resume2 = new Resume("Second name");
        resume2.setContact(ContactType.PHONE, "888-88-88");
        resume2.setSection(SectionType.ACHIEVEMENT, new ArrayList<>(Arrays.asList("first achive", "second achive", "third achiv")));
        resume2.setSection(SectionType.OBJECTIVE, "position");
        resume2.setSection(SectionType.PERSONAL, "about me");
        resume2.setSection(SectionType.QUALIFICATIONS, new ArrayList<>(Arrays.asList("first qua", " sec qua", "third qua")));

        HashMap<String, String> edu2 = new HashMap<>();
        HashMap<String, String> exp2 = new HashMap<>();
        edu2.put("school", "about");
        edu2.put("university", "about");
        edu2.put("courses", "about");
        exp2.put("first place", "about work");
        resume2.setSection(SectionType.EDUCATION, edu2);
        resume2.setSection(SectionType.EXPERIENCE, exp2);

        System.out.println();
        System.out.println(resume2.getFullName());
        resume2.getContacts().forEach((k, v) -> System.out.println(k + " " + v));
        resume2.getSectionType().forEach((k, v) -> System.out.println(k + " " + v));
    }
}