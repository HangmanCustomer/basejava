package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

public abstract class AbstractStorageTest {
    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private  static  String fullName1 = "First Full Name";
    private  static  String fullName2 = "Second Full Name";
    private  static  String fullName3 = "Third Full Name";
    private  static  String fullName4 = "Fourth Full Name";

    private static Resume resume1 = new Resume(UUID_1, fullName1);
    private static Resume resume2 = new Resume(UUID_2, fullName2);
    private static Resume resume3 = new Resume(UUID_3, fullName3);
    private static Resume resume4 = new Resume(UUID_4, fullName4);

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
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
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() {
        storage.update(resume1);
        assertSame(resume1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(resume4);
        assertSame(resume4, storage.get(UUID_4));
    }

    @Test
    public void getAll() {
        Resume[] testArray = {resume1, resume2, resume3};
        assertArrayEquals(testArray, storage.getAllSorted().toArray());
    }

    @Test
    public void save() {
        storage.save(resume4);
        assertSize(4);
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

    private void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}