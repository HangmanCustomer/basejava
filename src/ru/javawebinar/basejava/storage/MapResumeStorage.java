package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {

    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void doUpdate(Resume resume, Resume r) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doSave(Resume resume, Resume r) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Resume r) {
        storage.remove((r).getUuid());
    }

    @Override
    protected Resume doGet(Resume r) {
        return r;
    }

    @Override
    protected boolean isExist(Resume r) {
        return r != null;
    }

    @Override
    protected Resume getKey(String r) {
        return storage.get(r);
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
