package ru.javawebinar.basejava.storage;


import ru.javawebinar.basejava.model.Resume;


import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {


    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }


    @Override
    protected void directSave(Resume resume, int index) {
        if (index < 0) {
            index = Math.abs(index) - 1;
            System.arraycopy(storage, index, storage, index + 1, size - index);
            storage[index] = resume;
        }
    }

    @Override
    protected void directDelete(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
        storage[size - 1] = null;
    }
}
