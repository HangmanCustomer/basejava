import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void update(Resume r) {
        storage[0] = r;
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
        boolean noExist = true;
        for (int i = 0; i < size; i++) {
            if (storage[i] != r) {
                storage[size] = r;
            }else {
                storage[size] = null;
                System.out.println("Резюме уже в списке");
                noExist = false;
            }
        }
        if (noExist) {
            size++;
        }
        System.out.println(r);

    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("Резюме не найдено");
        return null;
    }

    void delete(String uuid) {
        int existSize = size;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, size);
                size--;
            }
        }
        if (existSize == size) {
            System.out.println("Резюме не найдено");
        }
    }

    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;
    }
}
