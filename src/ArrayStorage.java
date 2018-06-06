import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private Resume[] all;
    private int saveUuid = 0;

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        if (storage[saveUuid] != null) {
            saveUuid++;
            storage[saveUuid] = r;
        } else storage[saveUuid] = r;
    }

    Resume get(String uuid) {
        int i = 0;
        for (; i < size(); i++)
            if (storage[i].toString().equals(uuid))
                break;
        return storage[i];
    }

    void delete(String uuid) {
        int i = 0;
        for (; i < size(); i++)
            if (storage[i].toString().equals(uuid)) {
                for (; i < size(); i++)
                    storage[i] = storage[i + 1];
            }
    }

    Resume[] getAll() {
        all = Arrays.copyOf(storage, size());
        return all;
    }

    int size() {
        int size = 0;
        for (; size < storage.length; size++)
            if (storage[size] == null) {
                break;
            }
        return size;
    }
}
