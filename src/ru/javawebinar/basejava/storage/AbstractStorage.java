package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        doUpdate(resume, checkKey(resume.getUuid()));
    }

    public void save(Resume resume) {
        doSave(resume, checkSaveKey(resume.getUuid()));
    }

    public void delete(String uuid) {
        doDelete(checkKey(uuid));
    }

    public Resume get(String uuid) {
        return doGet(checkKey(uuid));
    }

    private Object checkSaveKey(String uuid) {
        int index = getKey(uuid);
        if (index < 0) {
            return index;
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    private Object checkKey(String uuid) {
        int index = getKey(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            return index;
        }
    }

    protected abstract void doUpdate(Resume resume, Object key);

    protected abstract void doSave(Resume resume, Object key);

    protected abstract void doDelete(Object key);

    protected abstract Resume doGet(Object key);

    protected abstract int getKey(Object key);
}
