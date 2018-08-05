package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            doUpdate(resume);
        }
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else doSave(resume);
    }

    public void delete(String uuid) {
        checkException(uuid);
        doDelete(uuid);
    }

    public Resume get(String uuid) {
        return doGet(checkException(uuid));
    }

    protected abstract Resume doGet(int index);

    protected abstract void doUpdate(Resume resume);

    protected abstract void doDelete(String uuid);

    protected abstract void doSave(Resume resume);

    protected abstract int getIndex(String uuid);

    protected abstract int checkException(String uuid);
}
