package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;

public class MapStorage extends AbstractStorage {
    protected HashMap <String, Resume> storage = new HashMap<>();


    @Override
    protected Resume doGet(String uuid) {
        return null;
    }

    @Override
    protected void doUpdate(Resume resume) {

    }

    @Override
    protected void doDelete(String uuid) {

    }

    @Override
    protected void doSave(Resume resume) {

    }

    @Override
    protected int getIndex(String uuid) {
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
