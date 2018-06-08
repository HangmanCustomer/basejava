import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        if (storage[size] == null) {
            storage[size] = r;
        } else {
            size++;
            storage[size] = r;
        }
    }

    Resume get(String uuid) {

        int j = 0;
        for (int i = 0; i <= size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                j = i;
                break;
            } else j = size + 1;
        }
        return storage[j];
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, size - i);
            }
        }
        size--;
    }

    Resume[] getAll() {
        if (size != 0) {
            return Arrays.copyOfRange(storage, 0, size + 1);
        } else return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        int filledArray;
        if (size != 0) {
            filledArray = size + 1;
        } else filledArray = 0;
        return filledArray;
    }
}
