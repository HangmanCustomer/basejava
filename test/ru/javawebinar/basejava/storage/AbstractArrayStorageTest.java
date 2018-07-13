package ru.javawebinar.basejava.storage;

import org.junit.After;
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

    public AbstractArrayStorageTest(Storage sStorage) {
        storage = sStorage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";


    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));

    }

    @After
    public void tearDown() {
        storage.clear();
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
        Resume r1 = new Resume(UUID_1);
        storage.update(r1);
        assertSame(storage.get("uuid1"), r1);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateFail() {
        Resume r1 = new Resume(UUID_1);
        storage.update(r1);
        assertSame(storage.get("uuid4"), r1);
    }

    @Test
    public void getAll() {
        assertEquals(storage.size(), storage.getAll().length);

    }

    @Test
    public void save() {
        assertEquals(3, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_1));
    }

    @Test
    public void delete() {
        storage.delete("uuid1");
        assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("uuid4");
    }

    @Test
    public void get() {
        assertEquals(storage.get("uuid1"), new Resume(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = StorageException.class)
    public void storageOverFlow() {
//        storage.save(new Resume("uuid4"));
    }
}