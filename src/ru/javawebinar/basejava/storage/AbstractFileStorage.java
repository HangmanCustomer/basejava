package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File derectory;

    protected AbstractFileStorage(File derectory) {
        Objects.requireNonNull(derectory, "directory must not be null");
        if (!derectory.isDirectory()) {
            throw new IllegalArgumentException(derectory.getAbsolutePath() + " is not a directory");
        }
        if (!derectory.canRead() || !derectory.canWrite()) {
            throw new IllegalArgumentException(derectory.getAbsolutePath() + " is not readable/writable");
        }
        this.derectory = derectory;
    }


    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doUpdate(Resume resume, File file) {
        try {
            doWrite(resume, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected void doSave(Resume resume, File file) {
        try {
            file.createNewFile();
            doWrite(resume, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    protected abstract void doWrite(Resume resume, File file) throws IOException;

    @Override
    protected void doDelete(File file) {
        file.delete();
    }

    @Override
    protected Resume doGet(File file) {
        return doRead(file);
    }

    protected abstract Resume doRead(File file);

    @Override
    protected File getKey(String uuid) {
        return new File(derectory, uuid);
    }

    @Override
    protected List<Resume> getResumeList() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }
}
