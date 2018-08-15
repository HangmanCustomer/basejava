package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        doUpdate(resume, getExistedKey(resume.getUuid()));
    }

    public void save(Resume resume) {
        doSave(resume, getNotExistedKey(resume.getUuid()));
    }

    public void delete(String uuid) {
        doDelete(getExistedKey(uuid));
    }

    public Resume get(String uuid) {
        return doGet(getExistedKey(uuid));
    }

    private Object getNotExistedKey(String uuid) {
        Object index = getKey(uuid);
        if (isExist(index)) {
            throw new ExistStorageException(uuid);
        } else {
            return index;
        }
    }

    private Object getExistedKey(String uuid) {
        Object index = getKey(uuid);
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        } else {
            return index;
        }
    }

    protected abstract boolean isExist(Object index);

    protected abstract void doUpdate(Resume resume, Object key);

    protected abstract void doSave(Resume resume, Object key);

    protected abstract void doDelete(Object key);

    protected abstract Resume doGet(Object key);

    protected abstract Object getKey(Object key);
}
