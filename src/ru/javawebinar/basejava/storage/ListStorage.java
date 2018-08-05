package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    protected ArrayList<Resume> storage = new ArrayList<>();

    @Override
    protected void doUpdate(int index) {
        storage.set(index, storage.get(index));
    }

    @Override
    protected void doSave(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void doDelete(int index) {
        storage.remove(index);
    }

    @Override
    protected Resume doGet(int index) {
        return storage.get(index);
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
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }

}