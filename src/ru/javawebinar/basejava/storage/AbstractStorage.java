package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    private static final Logger LOG = Logger.getLogger(ArrayStorage.class.getName());

    public void update(Resume resume) {
        LOG.info("Update " + resume);
        doUpdate(resume, getExistedKey(resume.getUuid()));
    }

    public void save(Resume resume) {
        LOG.info("Save " + resume);
        doSave(resume, getNotExistedKey(resume.getUuid()));
    }

    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        doDelete(getExistedKey(uuid));
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        return doGet(getExistedKey(uuid));
    }

    private SK getNotExistedKey(String uuid) {
        SK key = getKey(uuid);
        if (isExist(key)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        } else {
            return key;
        }
    }

    private SK getExistedKey(String uuid) {
        SK key = getKey(uuid);
        if (!isExist(key)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        } else {
            return key;
        }
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("GetAllSorted");
        List<Resume> sortedList = doCopyAll();
        sortedList.sort(Resume::compareTo);
        return sortedList;
    }

    protected abstract boolean isExist(SK key);

    protected abstract void doUpdate(Resume resume, SK key);

    protected abstract void doSave(Resume resume, SK key);

    protected abstract void doDelete(SK key);

    protected abstract Resume doGet(SK key);

    protected abstract SK getKey(String key);

    protected abstract List<Resume> doCopyAll();
}
