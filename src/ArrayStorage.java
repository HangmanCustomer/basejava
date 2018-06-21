import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void update(Resume r) {
        int search = search(r.uuid);
        if (search < 0) {
            System.out.println("Резюме не найдено");
        } else {
            storage[search] = r;
            System.out.println("Резюме изменено на " + r);
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
        int search = search(r.uuid);
        if (search < 0) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Резуме " + r + " уже заведено");
        }
    }

    Resume get(String uuid) {
        int search = search(uuid);
        if (search < 0) {
            System.out.println("Резюме не найдено");
            return null;
        } else {
            return storage[search];
        }
    }

    void delete(String uuid) {
        int search = search(uuid);
        if (search < 0) {
            System.out.println("Резюме не удалить");
        } else {
            storage[search] = storage[size - 1];
            size--;
        }
    }

    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;

    }

    private int search(String uuid) {
        for (int search = 0; search < size; search++) {
            if (storage[search].uuid.equals(uuid)) {
                return search;
            }
        }
        return -1;
    }
}
