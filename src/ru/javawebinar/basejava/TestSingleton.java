package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Contacts;
import ru.javawebinar.basejava.model.SectionType;

import java.util.HashMap;
import java.util.Map;

public class TestSingleton {
   /* private static TestSingleton ourInstance;

    public static TestSingleton getInstance() {
        if (ourInstance == null)
            ourInstance = new TestSingleton();
        return ourInstance;
    }

    private TestSingleton() {
    }*/

    public static void main(String[] args) {

//        System.out.println(getInstance().toString());
      //  TestSingleton.getInstance().toString();
//        Singleton singleton = Singleton.valueOf("INSTANCE");
//        System.out.println(singleton.name() + " " + singleton.ordinal());
//        Singleton singleton1 = Singleton.valueOf("INST");
//        System.out.println(singleton1.name() + " " + singleton1.ordinal());

//        for(Singleton s : Singleton.values()){
//            System.out.println(s + " " + s.ordinal());
//        }
//        for (SectionType type : SectionType.values()){
//            System.out.println(type + " " + type.getTitle() + " " + type.ordinal());
//        }
        Map<String, SectionType> sectionTypes = new HashMap<>();
        for (SectionType type : SectionType.values()){
            sectionTypes.put(type.getTitle(),type);
        }
        for (Map.Entry entry : sectionTypes.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }

        System.out.println("---------||---------");

        Map<String, String> contacts = new HashMap<>();
        for (Contacts cont : Contacts.values()){
            contacts.put(cont.name(), cont.getValue());
        }
        for (Map.Entry entry : contacts.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
    }

    private enum Singleton{
        INSTANCE,
        INST
    }

}
