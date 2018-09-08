package ru.javawebinar.basejava.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ResumeTest {
    String firstName = "FirstName";
    String secondName = "SecondName";

    Resume resume1 = new Resume(firstName, new ArrayList<>(Arrays.asList("666-66-66", "skype FirstName info",
            "mail FirstName info", "linkedin FirstName info", "github FirstName info"
            , "StackOverFlow FirstName info", "Home page FirstName info")));
    Resume resume2 = new Resume(secondName, new ArrayList<>(Arrays.asList("777-77-77", "skype SecondName info",
            "mail SecondName info", "linkedin SecondName info", "github SecondName info"
            , "StackOverFlow SecondName info", "Home page SecondName info")));

    @Before
    public void setUp() {
        for (ContactType contactType : ContactType.values()) {
            resume1.getContacts().put(contactType, resume1.getContactList().get(contactType.ordinal()));
        }
        for (ContactType contactType : ContactType.values()) {
            resume2.getContacts().put(contactType, resume2.getContactList().get(contactType.ordinal()));
        }
    }

    @Test
    public void fullName() {
        assertEquals(resume1.getFullName(), firstName);
        assertEquals(resume2.getFullName(), secondName);
    }

    @Test
    public void contactsTest() {
        List<String> testArray = Arrays.asList("666-66-66", "skype FirstName info",
                "mail FirstName info", "linkedin FirstName info", "github FirstName info"
                , "StackOverFlow FirstName info", "Home page FirstName info");
        List<String> checkList = new ArrayList<>();
        resume1.getContacts().forEach((key, value) -> checkList.add(value));
        assertEquals(testArray, checkList);
    }

    @Test
    public void notSameResume() {
        List<String> checkList1 = new ArrayList<>();
        List<String> checkList2 = new ArrayList<>();
        resume1.getContacts().forEach((key, value) -> checkList1.add(value));
        resume2.getContacts().forEach((key, value) -> checkList2.add(value));
        assertNotEquals(checkList1, checkList2);
    }
}