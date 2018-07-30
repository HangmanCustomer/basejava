package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {
    protected ArrayList<Resume> storage = new ArrayList<>();

    @Override
    public void update(Resume resume) {

    }

    @Override
    public void save(Resume resume) {
        storage.add(resume);
        size++;

    }

    @Override
    public Resume get(String uuid) {
        System.out.println(storage.get(0));
        int index = storage.indexOf(uuid);
     //   System.out.println(storage.contains("uuid1"));
    return storage.get(index);
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    protected void clearAllStorage() {
        storage.clear();

    }
}
