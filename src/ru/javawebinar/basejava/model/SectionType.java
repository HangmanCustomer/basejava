package ru.javawebinar.basejava.model;

import java.util.ArrayList;

public enum SectionType {

    ACHIEVEMENT("-Достижения") {
        @Override
        public ArrayList getSectionInfo() {
            ArrayList<String> achievements = new ArrayList<>();
            achievements.add("first achievement");
            achievements.add("second achievement");
            achievements.add("third achievement");
            return achievements;
        }
    },
    QUALIFICATIONS("-Квалификация") {
        @Override
        public ArrayList getSectionInfo() {
            ArrayList<String> qualifications = new ArrayList<>();
            qualifications.add("first qualification");
            qualifications.add("second qualification");
            return qualifications;
        }
    },
    EXPERIENCE("-Опыт работы") {
        @Override
        public ArrayList getSectionInfo() {
            ArrayList<String> experiance = new ArrayList<>();
            experiance.add("Last place");
            experiance.add("before that");
            return experiance;
        }
    },
    EDUCATION("-Образование") {
        @Override
        public ArrayList getSectionInfo() {
            ArrayList<String> education = new ArrayList<>();
            education.add("College");
            education.add("School");
            return education;
        }
    };

    private String title;


    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList getSectionInfo() {
        return null;
    }

    @Override
    public String toString() {
        return name();
    }

}
