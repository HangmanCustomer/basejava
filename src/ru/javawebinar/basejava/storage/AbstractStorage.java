package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        doUpdate(resume, checkIndex(resume.getUuid()));
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            doSave(resume, index);
        }
    }

    public void delete(String uuid) {
        doDelete(checkIndex(uuid));
    }

    public Resume get(String uuid) {
        return doGet(checkIndex(uuid));
    }

    private int checkIndex(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }


    protected abstract void doUpdate(Resume resume, int index);

    protected abstract void doSave(Resume resume, int index);

    protected abstract void doDelete(int index);

    protected abstract Resume doGet(int index);

    protected abstract int getIndex(String uuid);
}
