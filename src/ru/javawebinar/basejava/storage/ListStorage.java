package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    protected ArrayList<Resume> storage = new ArrayList<>();

    @Override
    protected void doUpdate(Resume resume, Object index) {
        storage.set((int) index, resume);
    }

    @Override
    protected void doSave(Resume resume, Object index) {
        storage.add(resume);
    }

    @Override
    protected void doDelete(Object index) {
        storage.remove((int) index);
    }

    @Override
    protected Resume doGet(Object index) {
        return storage.get((int) index);
    }

    @Override
    protected int getKey(Object uuid) {
        return storage.indexOf(new Resume((String) uuid));
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

}