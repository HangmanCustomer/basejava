package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected int size = 0;

    @Override
    public void clear() {
        clearAllStorage();
        size = 0;
    }

    protected abstract void clearAllStorage();

    @Override
    public int size() {
        return size;
    }

}
