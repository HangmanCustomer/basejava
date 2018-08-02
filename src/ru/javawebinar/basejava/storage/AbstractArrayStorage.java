package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void doUpdate(Resume resume) {
        storage[getIndex(resume.getUuid())] = resume;
    }


    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected void doSave(Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage Overflow", resume.getUuid());
        } else {
            insertElement(resume, getIndex(resume.getUuid()));
            size++;
        }
    }

    @Override
    protected void doDelete(String uuid) {
        fillDeletedElement(getIndex(uuid));
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Resume doGet(String uuid) {
        return storage[getIndex(uuid)];
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume resume, int index);
}