package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        doUpdate(resume, (int) checkKey(resume.getUuid()));
    }

    public void save(Resume resume) {
        doSave(resume, (int) checkSaveKey(resume.getUuid()));
    }

    public void delete(String uuid) {
        doDelete(checkKey(uuid));
    }

    public Resume get(String uuid) {
        return doGet(checkKey(uuid));
    }

    private Object checkSaveKey(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            return index;
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    private Object checkKey(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            return index;
        }
    }

    protected abstract void doUpdate(Resume resume, int index);

    protected abstract void doSave(Resume resume, int index);

    protected abstract void doDelete(Object o);

    protected abstract Resume doGet(Object o);

    protected abstract int getIndex(String uuid);
}
