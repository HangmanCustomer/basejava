package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    protected ArrayList<Resume> storage = new ArrayList<>();


    @Override
    protected Resume doGet(int index) {
        return storage.get(index);
    }

    @Override
    protected void doUpdate(Resume resume) {
        storage.set(getIndex(resume.getUuid()), resume);
    }

    @Override
    protected void doDelete(String uuid) {
        storage.remove(uuid);
    }

    @Override
    protected void doSave(Resume resume) {
        storage.add(resume);
        System.out.println(storage.toString());
        System.out.println(storage.indexOf(resume));
    }

    @Override
    protected int getIndex(String uuid) {
        return storage.indexOf(uuid);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) storage.toArray();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected int checkException(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }
}