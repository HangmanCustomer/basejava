package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage<String> {

    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void doUpdate(Resume resume, String key) {
        storage.put(key, resume);
    }

    @Override
    protected void doSave(Resume resume, String key) {
        storage.put(key, resume);
    }

    @Override
    protected void doDelete(String key) {
        storage.remove(key);
    }

    @Override
    protected Resume doGet(String key) {
        return storage.get(key);
    }

    @Override
    protected boolean isExist(String key) {
        return storage.get(key) != null;
    }

    @Override
    protected String getKey(String key) {
        return key;
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(storage.values());
    }
}
