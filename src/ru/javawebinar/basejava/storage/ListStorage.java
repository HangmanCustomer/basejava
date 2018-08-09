package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    protected ArrayList<Resume> storage = new ArrayList<>();

    @Override
    protected void doUpdate(Resume resume, int index) {
        storage.set(index, resume);
    }

    @Override
    protected void doSave(Resume resume, int index) {
        storage.add(resume);
    }

    @Override
    protected void doDelete(Object o) {
        storage.remove((int) o);
    }

    @Override
    protected Resume doGet(Object o) {
        return storage.get((int) o);
    }

    @Override
    protected int getIndex(String uuid) {
        return storage.indexOf(new Resume(uuid));
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