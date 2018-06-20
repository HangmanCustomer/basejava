import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void update(String uuid) {
        storage[0] = get(uuid);
        System.out.println("Резюме изменено");
    }

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Массив заполнен");
            return;
        }
        storage[size] = r;
        size++;

    }

    Resume get(String uuid) {
        if (storage[searching(uuid)] == null) {
            System.out.println("Резюме не найдено");
            return null;
        } else {
            return storage[searching(uuid)];
        }
    }

    void delete(String uuid) {
        if (storage[searching(uuid)] == null) {
            System.out.println("Резюме не удалить ибо не найдено");
        } else {
            System.arraycopy(storage, searching(uuid) + 1, storage, searching(uuid), size);
            size--;
        }
    }

    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;

    }

    int searching(String uuid) {
        int search;
        for (search = 0; search < size; search++) {
            if (storage[search].uuid.equals(uuid)) {
                break;
            }
        }
        return search;
    }
}
