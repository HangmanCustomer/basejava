package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.util.ArrayList;
import java.util.Arrays;

public class MainTestResume {
    public static void main(String[] args) {
        Resume resume1 = new Resume("First name");
        resume1.setContact(ContactType.PHONE, "777-77-77");
        resume1.setContact(ContactType.SKYPE, "User's Skype");
        resume1.setContact(ContactType.GITHUB, "GitHub Link");
        resume1.setContact(ContactType.LINKED_IN, "LinkedIn link");
        resume1.setContact(ContactType.STACK_OVER_FLOW, "OverFlow link");
        resume1.setContact(ContactType.HOME_PAGE, "HOME_PAGE");
        resume1.setContact(ContactType.MAIL, "e_mail");

        TextSection personalText = new TextSection("about me");
        TextSection objText = new TextSection("objective inform");
        ListSection achieveText = new ListSection(new ArrayList(Arrays.asList("first achieve", "second achieve")));
        ListSection quaText = new ListSection(new ArrayList(Arrays.asList("first qua", "second qua")));
        Place studyFirstPlace = new Place("School", "11.11.11", "was boring");
        Place studySecondPlace = new Place("University", "22.22.22", "was cool");
        Place studyThirdPlace = new Place("Courses", "44.44.44", "was interesting");

        Place expFirstPlace = new Place("First place", "33.33.33", "knew nothing");
        Place expSecondPlace = new Place("Second place", "44.44.44", "something new");

        PlaceSection studyText = new PlaceSection(new ArrayList<>(Arrays.asList(studyFirstPlace, studySecondPlace, studyThirdPlace)));
        PlaceSection expText = new PlaceSection(new ArrayList<>(Arrays.asList(expFirstPlace, expSecondPlace)));


        resume1.setSection(SectionType.OBJECTIVE, objText);
        resume1.setSection(SectionType.PERSONAL, personalText);
        resume1.setSection(SectionType.ACHIEVEMENT, achieveText);
        resume1.setSection(SectionType.QUALIFICATIONS, quaText);
        resume1.setSection(SectionType.EDUCATION, studyText);
        resume1.setSection(SectionType.EXPERIENCE, expText);


        System.out.println(resume1.getFullName());
        resume1.getContacts().forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println();
        resume1.getSectionType().forEach((k, v) -> System.out.println(k + " " + v + "\n"));
    }
}
