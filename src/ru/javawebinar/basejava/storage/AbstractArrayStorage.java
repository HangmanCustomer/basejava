package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.NotExistStorageException;
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
    protected void abstractUpdate(Resume resume) {
        storage[getIndex(resume.getUuid())] = resume;
    }

    /*public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            storage[index] = resume;
        }
    }*/

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected void abstractSave(Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage Overflow", resume.getUuid());
        } else {
            insertElement(resume, getIndex(resume.getUuid()));
            size++;
        }
    }

 /*   public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage Overflow", resume.getUuid());
        } else {
            insertElement(resume, index);
            size++;
        }
    }*/

    @Override
    protected void abstractDelete(String uuid) {
        fillDeletedElement(getIndex(uuid));
        storage[size - 1] = null;
        size--;
    }

    /*public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }*/

    @Override
    protected Resume abstractGet(String uuid) {
        return storage[getIndex(uuid)];
    }

    /* public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }*/
}