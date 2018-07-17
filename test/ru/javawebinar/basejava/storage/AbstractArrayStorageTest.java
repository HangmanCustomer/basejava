package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    Resume resume1 = new Resume(UUID_1);
    Resume resume2 = new Resume(UUID_2);
    Resume resume3 = new Resume(UUID_3);

    public AbstractArrayStorageTest(Storage sStorage) {
        storage = sStorage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);

    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        storage.update(resume1);
        assertSame(resume1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateFail() {
        storage.update(resume1);
        assertSame(resume1, storage.get(UUID_4));
    }

    @Test
    public void getAll() {
        Resume[] testArray = {resume1, resume2, resume3};
        assertArrayEquals(testArray, storage.getAll());
    }

    @Test
    public void save() {
        assertEquals(3, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        storage.save(resume1);
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_4);
    }

    @Test
    public void get() {
        assertEquals(resume1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(UUID_4);
    }

    @Test
    public void storageOverFlow() throws StorageException {
        int storageLim = AbstractArrayStorage.STORAGE_LIMIT;
        for (int i = 2; i < storageLim + 1; i++) {
            try {
                storage.save(new Resume());
                if (storage.size() > storageLim) {
                    Assert.fail("fail");
                }
            } catch (StorageException e) {
                assert (e.getMessage() == "Storage Overflow");
            }
        }
    }
}

