package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void update(Resume r) {
        int search = search(r.getUuid());
        if (search < 0) {
            System.out.println("Резюме не найдено");
        } else {
            storage[search] = r;
            System.out.println("Резюме изменено");
        }
    }


    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Массив заполнен");
            return;
        }
        int search = search(r.getUuid());
        if (search < 0) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Резюме " + r + " уже заведено");
        }
    }

    public Resume get(String uuid) {
        int search = search(uuid);
        if (search < 0) {
            System.out.println("Резюме не найдено");
            return null;
        } else {
            return storage[search];
        }
    }

    public void delete(String uuid) {
        int search = search(uuid);
        if (search < 0) {
            System.out.println("Резюме не удалить");
        } else {
            storage[search] = storage[size - 1];
            size--;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;

    }

    private int search(String uuid) {
        for (int search = 0; search < size; search++) {
            if (storage[search].getUuid().equals(uuid)) {
                return search;
            }
        }
        return -1;
    }
}
