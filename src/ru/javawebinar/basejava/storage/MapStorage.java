package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;

public class MapStorage extends AbstractStorage {
    protected HashMap<String, Resume> storage = new HashMap<>();


    @Override
    protected void doUpdate(Resume resume, Object key) {

    }

    @Override
    protected void doSave(Resume resume, Object key) {

    }

    @Override
    protected void doDelete(Object key) {

    }

    @Override
    protected Resume doGet(Object key) {
        return null;
    }

    @Override
    protected int getKey(Object key) {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }


}
