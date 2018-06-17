import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void update(Resume r) {
        String oldUuid;
        String newUuid;
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(r)) {
                oldUuid = storage[i].uuid;
                storage[i].uuid = "uuidUpdate";
                newUuid = storage[i].uuid;
                System.out.println("Резюме " + oldUuid + " изменено на " + newUuid);
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
            System.exit(0);
        }
        for (int i = 0; i < size; i++) {
            if (storage[i] != r) {
                System.out.println("Резюме еще нет в списке");
            }
        }
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                System.out.println("Резюме " + storage[i].uuid + " есть в списке и получено");
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                System.out.println("Резюме " + storage[i].uuid + " есть в списке и удалено");
                System.arraycopy(storage, i + 1, storage, i, size);
                size--;
            }
        }
    }

    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;
    }
}
