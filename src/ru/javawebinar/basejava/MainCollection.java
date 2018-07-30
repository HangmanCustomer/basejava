package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainCollection {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static Resume resume1 = new Resume(UUID_1);
    private static Resume resume2 = new Resume(UUID_2);
    private static Resume resume3 = new Resume(UUID_3);
    private static Resume resume4 = new Resume(UUID_4);

    public static void main(String[] args) {

        Map <String, Resume> map = new TreeMap<>();
        map.put(UUID_1, resume1);
        map.put(UUID_2, resume2);
        map.put(UUID_3, resume3);
        map.put(UUID_4, resume4);

        for(String uuid : map.keySet()){
            System.out.println(map.get(uuid));
        }
        System.out.println();
        for(Map.Entry<String, Resume> entry : map.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
