import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void update(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                storage[i] = r;
                System.out.println("Резюме изменено");
            }
        }
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
        boolean exist = false;
        for (int i = 0; i < size; i++) {
            if (storage[i] != r) {
                exist = false;
            } else {
                exist = true;
                storage[size] = null;
                System.out.println("Резуме " + r + " уже заведено");
                break;
            }
        }
        if (!exist) {
            size++;
        }
    }

    Resume get(String uuid) {
        if (searched(uuid) < 0) {
            System.out.println("Резюме не найдено");
            return null;
        } else {
            return storage[searched(uuid)];
        }
    }

    void delete(String uuid) {
        if (searched(uuid) < 0) {
            System.out.println("Резюме не удалить так как не найдено");
        } else {
            System.arraycopy(storage, searched(uuid) + 1, storage, searched(uuid), size);
            size--;
        }
    }

    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;

    }

    private int searched(String uuid) {
        for (int search = 0; search < size; search++) {
            if (storage[search].uuid.equals(uuid)) {
                return search;
            }
        }
        return -1;
    }
}
