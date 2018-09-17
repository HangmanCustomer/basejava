package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public enum SectionType {
    PERSONAL("-Личные качества"),
    OBJECTIVE("-Позиция"),
    ACHIEVEMENT("-Достижения"),
    QUALIFICATIONS("-Квалификация"),
    EXPERIENCE("-Опыт работы"),
    EDUCATION("-Образование");

    },
    ACHIEVEMENT("-Достижения") {
        @Override
        public void getSectionInfo() {
            ArrayList<String> list = new ArrayList<>();
            list.add("Достижение 01");
            list.add("Достижение 02");
            list.forEach(System.out::println);
        }

    },
    QUALIFICATIONS("-Квалификация") {
        @Override
        public void getSectionInfo() {
            ArrayList<String> list = new ArrayList<>();
            list.add("Технология 01");
            list.add("Технология 02");
            list.forEach(System.out::println);
        }
    },
    EXPERIENCE("-Опыт работы") {
        @Override
        public void getSectionInfo() {
            Map<String, String> map = new TreeMap<>();
            map.put("Компания 01", "Должность и задачи");
            map.put("Компания 02", "Должность и задачи");
            map.put("Компания 03", "Должность и задачи");
            map.forEach((key, value) -> System.out.println(key + " " + value));
        }
    },
    EDUCATION("-Образование") {
        @Override
        public void getSectionInfo() {
            Map<String, String> map = new TreeMap<>();
            map.put("Конференция 01", "Знания");
            map.put("Конференция 02", "Знания");
            map.put("Университет", "время обучения");
            map.forEach((key, value) -> System.out.println(key + " " + value));
        }
    };
    private String title;

    SectionType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

   // abstract Object typePrint(Object o);
}
