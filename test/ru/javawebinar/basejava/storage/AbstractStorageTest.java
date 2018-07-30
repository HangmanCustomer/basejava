package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

public abstract class AbstractStorageTest {
    protected Storage storage;

    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final String UUID_4 = "uuid4";

    protected static final Resume resume1 = new Resume(UUID_1);
    protected static final Resume resume2 = new Resume(UUID_2);
    protected static final Resume resume3 = new Resume(UUID_3);
    protected static final Resume resume4 = new Resume(UUID_4);

    public AbstractStorageTest(Storage sStorage) {
        storage = sStorage;
    }


    @Before
    public void setUp() {
        clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void save() {
        storage.save(resume4);
        assertSize(4);
    }

    @Test
    public void get() {
        assertGet(resume1);
    }

    protected void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }

    protected void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }

}