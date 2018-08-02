package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    private Storage storage;

    public AbstractArrayStorageTest(Storage sStorage) {
        super(sStorage);
        storage = sStorage;
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
}


