package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.ArrayStorage;
import ru.javawebinar.basejava.storage.SortedArrayStorage;

/**
 * Test ru.javawebinar.basejava.storage.ArrayStorage
 */
public class MainTestArrayStorage {
    private static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();
    private static final SortedArrayStorage SORTED_ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume("");
        final Resume r2 = new Resume("");
        final Resume r3 = new Resume("");
        final Resume r4 = new Resume("");

        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

     //   System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        printAll();
//        ARRAY_STORAGE.delete(r1.getUuid());
        ARRAY_STORAGE.update(r3);
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("--------------|| SORTED || -----------------");

        SORTED_ARRAY_STORAGE.save(r1);
        SORTED_ARRAY_STORAGE.save(r3);
        SORTED_ARRAY_STORAGE.save(r2);

        System.out.println("Get r1: " + SORTED_ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + SORTED_ARRAY_STORAGE.size());

        //System.out.println("Get dummy: " + SORTED_ARRAY_STORAGE.get("dummy"));

        printSortedAll();
      //  SORTED_ARRAY_STORAGE.delete(r2.getUuid());
        SORTED_ARRAY_STORAGE.update(r1);
        printSortedAll();
        SORTED_ARRAY_STORAGE.clear();
        printSortedAll();

        System.out.println("Size: " + SORTED_ARRAY_STORAGE.size());

    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }

    private static void printSortedAll() {
        System.out.println("\nGet All");
        for (Resume r : SORTED_ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}