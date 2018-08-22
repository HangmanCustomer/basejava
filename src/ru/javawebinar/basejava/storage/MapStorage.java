package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapStorage extends AbstractStorage {

    protected Map<String, Resume> storage = new TreeMap<>();

    @Override
    protected void doUpdate(Resume resume, Object key) {
        storage.put((String) key, resume);
    }

    @Override
    protected void doSave(Resume resume, Object key) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object key) {
        storage.remove(key);
    }

    @Override
    protected Resume doGet(Object key) {
        return storage.get(key);
    }

    @Override
    protected boolean isExist(Object key) {
        for (Map.Entry<String, Resume> entry : storage.entrySet())
            if (entry.getKey().equals(key))
                return key != null;
        return false;
    }


    @Override
    protected Object getKey(Object key) {
        return key;
    }

    @Override
    public void clear() {
        storage.clear();

    }

    @Override
    public List<Resume> getAllSorted() {
        return new ArrayList<>(storage.values());
    }


    @Override
    public int size() {
        return storage.size();
    }


}
