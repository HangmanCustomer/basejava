package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;
import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest{

    public AbstractArrayStorageTest(Storage sStorage) {
        super(sStorage);
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);

    }


    @Test
    public void update() {
        storage.update(resume1);
        assertGet(resume1);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(resume4);
        assertGet(resume4);
    }

    @Test
    public void getAll() {
        Resume[] testArray = {resume1, resume2, resume3};
        assertArrayEquals(testArray, storage.getAll());
    }

    @Test(expected = StorageException.class)
    public void storageOverFlow() throws StorageException {
        for (int i = storage.size(); i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
            try {
                storage.save(new Resume());
            } catch (StorageException e) {
                Assert.fail("fail");
            }
        }
        storage.save(new Resume());
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        storage.save(resume1);
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        assertSize(2);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_4);
    }

    @Test
    public void get() {
        assertGet(resume1);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(UUID_4);
    }


}


